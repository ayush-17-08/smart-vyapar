package com.infinity.commerce.smart_vyapar.model;

import com.infinity.commerce.smart_vyapar.enums.Category;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Product {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String brand;
    private Integer quantity;
    private Integer minQuantity;
    private String seller;
    //storage
    private Double price;
    private String description;
//    private Category category;
//    private Boolean archived;
//    private Date expiryDate;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", quantity=" + quantity +
                ", minQuantity=" + minQuantity +
                ", seller='" + seller + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
//                ", category=" + category +
//                ", archived=" + archived +
//                ", expiryDate=" + expiryDate +
                '}';
    }

//    @CreatedDate
//    @Column(nullable = false,updatable = false)
//    private LocalDateTime createdAt;

//    @LastModifiedDate
  //  private LocalDateTime updatedAt;
}
