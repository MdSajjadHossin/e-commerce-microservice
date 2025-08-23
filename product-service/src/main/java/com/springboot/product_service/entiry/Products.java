package com.springboot.product_service.entiry;

import com.springboot.product_service.configuration.IdGenerator;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Products {

    @Id
    private String productId;
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    private Boolean inStock;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;


    @PrePersist
    @PreUpdate
    public void updateStockStatus(){
        this.inStock = this.quantity != null && this.quantity >0;
        if(createdAt == null) createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();

        // Id generator
        if(this.productId == null){
            this.productId = "prod-"+String.format("%05d", IdGenerator.generateProductId());
        }
    }

}
