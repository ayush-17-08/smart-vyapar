    package com.infinity.commerce.smart_vyapar.controller;

    import com.infinity.commerce.smart_vyapar.entity.Product;
    import com.infinity.commerce.smart_vyapar.repository.ProductRepository;
    import com.infinity.commerce.smart_vyapar.service.ProductService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.Objects;

    @RestController()
    @RequestMapping("/product")
    public class ProductController {

        @Autowired
        ProductService productService;

        @GetMapping("/health-check")
        public Boolean getHealthStatus(){
            return true;
        }

        @GetMapping("/get/{id}")
        public ResponseEntity<?> getById(@PathVariable Long id){
            Product product=productService.getById(id);

            if(product!=null){
                return ResponseEntity.status(HttpStatus.OK).body(product);
            }
            else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid id !");
            }
        }

        @PostMapping("/add")
        public ResponseEntity<Product> add(@RequestBody Product product){
    //        System.out.println("Message: "+ product);
            Boolean serviceResponse=productService.add(product); // by reference
            if(serviceResponse){
                return ResponseEntity.status(HttpStatus.CREATED).body(product);
            }
            else{
                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
            }
        }

    }
