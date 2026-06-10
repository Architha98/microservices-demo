package ecom.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Inventory {
    @Id
    private Long productId;

    private int quantity;

    public Inventory(Long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
}
