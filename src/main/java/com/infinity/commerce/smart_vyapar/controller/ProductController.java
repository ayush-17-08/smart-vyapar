package com.infinity.commerce.smart_vyapar.controller;

import com.infinity.commerce.smart_vyapar.model.Product;
import com.infinity.commerce.smart_vyapar.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/health-check")
    public Boolean getHealthStatus(){
        return true;
    }

    @PostMapping("/add")
    public void addProduct(@RequestBody Product product){
        System.out.println("ProductOutput="+product);
        productRepository.save(product);
    }



}
