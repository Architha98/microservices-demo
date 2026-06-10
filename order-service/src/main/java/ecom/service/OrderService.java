package ecom.service;

import ecom.config.FeignClientConfig;

import ecom.dto.Inventory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    private final FeignClientConfig clientConfig;
    private final RestClient restClient;

    private final RestTemplate restTemplate;

    public OrderService(FeignClientConfig clientConfig, RestClient restClient, RestTemplate restTemplate) {
        this.clientConfig = clientConfig;
        this.restClient = restClient;
        this.restTemplate = restTemplate;
    }

    public String placeOrder(Long productId){

        //TODO call inventory service to check stock
      /*  String response = restTemplate.getForObject("http://localhost:8081/inventory/" + productId,
                String.class);*/

        //rest client
//        ResponseEntity<Inventory> response = restClient.get()
//                .uri("http://localhost:8081/inventory/{productId}", productId)
//                .retrieve()
//                .toEntity(Inventory.class);

        Inventory inventory = clientConfig.getInventory(productId);
        updateInventory(inventory);

        return inventory!=null && inventory.getQuantity()>0?
               "ORDER PLACED SUCCESSFULLY": "Product is out of Stock";

    }

    private void updateInventory(Inventory inventory) {
        inventory.setQuantity(inventory.getQuantity()-1);
        restClient.post()
                .uri("http://localhost:8081/inventory")
                .body(inventory)
                .retrieve()
                .toBodilessEntity();
    }
}
