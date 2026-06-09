package ecom.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @GetMapping("/{productId}")
    public String checkInventory(@PathVariable String productId){
        System.out.println("CHECK " + productId);
        return productId.equals("1")? "IN STOCK" : "OUT OF STOCK";

    }
}
