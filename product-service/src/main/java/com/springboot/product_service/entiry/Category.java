package com.springboot.product_service.entiry;

import com.springboot.product_service.configuration.IdGenerator;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    private String categoryId;
    private String name;
    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Products> products;

    @PrePersist
    public void generateId(){
        if(this.categoryId == null){
            this.categoryId = "cat-"+String.format("%05", IdGenerator.generateCategoryId());
        }
    }
}
