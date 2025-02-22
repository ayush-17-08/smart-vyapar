package com.infinity.commerce.smart_vyapar.service;

import com.infinity.commerce.smart_vyapar.entity.Product;
import com.infinity.commerce.smart_vyapar.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository ;

    public Boolean add(Product product){
        productRepository.save(product);
        return true;
    }

    public Product getById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}

