package ecom.service;

import ecom.entity.Inventory;
import ecom.repo.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public Inventory checkStock(Long productId){
        return inventoryRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Inventory not found with id: " + productId));


    }

    public String addProduct(Inventory inventory){
         inventoryRepository.save(inventory);
         return "Product Added";
    }

    public String updateProduct(Inventory inventory) {
        inventoryRepository.save(inventory);
        return "Product Ipdated";
    }

    public void deleteProduct(Long productId) {
        inventoryRepository.deleteById(productId);
    }
}

