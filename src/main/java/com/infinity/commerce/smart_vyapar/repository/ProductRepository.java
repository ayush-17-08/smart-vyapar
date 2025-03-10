package com.infinity.commerce.smart_vyapar.repository;

import com.infinity.commerce.smart_vyapar.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface    ProductRepository extends JpaRepository<Product,Long> {
    @Query("select p from Product p  where p.archived != true")
    public List<Product> findNotArchived();
}

