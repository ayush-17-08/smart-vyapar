package com.infinity.commerce.smart_vyapar.service;

import com.infinity.commerce.smart_vyapar.entity.Product;
import com.infinity.commerce.smart_vyapar.enums.TransactionStatus;
import com.infinity.commerce.smart_vyapar.enums.TransactionType;
import com.infinity.commerce.smart_vyapar.kafka.TransactionEvent;
import com.infinity.commerce.smart_vyapar.kafka.TransactionProducer;
import com.infinity.commerce.smart_vyapar.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository ;

    @Autowired
    TransactionProducer transactionProducer;

    private final String topic="product-event";

    public Boolean add(Product product){
        productRepository.save(product);
        TransactionEvent transactionEvent=new TransactionEvent(product.getId(), TransactionType.BUY, TransactionStatus.SUCCESS,product.getQuantity());
        transactionProducer.sendEvent(topic,transactionEvent);
        return true;
    }
    //change code according to archive
    public Product getById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
    //custom query --select * where archive is not true
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product updateById(Long id,Product requestedProduct) {
        //check archive for readbyid updatebyid
        Product product=productRepository.findById(id).orElse(null);
        if(product!=null){
            requestedProduct.setId(product.getId());
            return productRepository.save(requestedProduct);
        }
        else{
            return null;
        }
        //save will automatically update it how?
        //what if the requested update is same even after updating ? ask
    }

    public Product deleteById(Long id) {
        //delete by id -->Repository--->db
        Product deletableProduct=productRepository.findById(id).orElse(null);
        if(deletableProduct!=null){
            deletableProduct.setArchived(true);
            productRepository.save(deletableProduct);
            return deletableProduct;
        }
        else  return null;
        //how would locking on DB work in our project , how should we handle it
    }
}

