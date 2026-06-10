package ecom.config;


import ecom.dto.Inventory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service", url = "http://localhost:8081")
public interface FeignClientConfig {

    @GetMapping("/inventory/{productId}")
    Inventory getInventory(@PathVariable Long productId);
}
