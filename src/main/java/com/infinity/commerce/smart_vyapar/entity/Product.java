package com.infinity.commerce.smart_vyapar.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.infinity.commerce.smart_vyapar.enums.Category;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Date;

@Data  // Auto-generates getters, setters, toString, equals, and hashCode
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String brand;
    private Integer quantity;
    private Integer minQuantity;
    private String seller;
    //storage
    private Double price;
    private String description;

    @Enumerated(EnumType.STRING)
    private Category category;
    private Boolean archived;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date expiryDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @CreatedDate
    @Column(nullable = false,updatable = false)
    private LocalDateTime createdAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @LastModifiedDate
    private LocalDateTime updatedAt;

}
