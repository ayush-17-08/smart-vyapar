    package com.infinity.commerce.smart_vyapar.controller;

    import com.infinity.commerce.smart_vyapar.entity.Product;
    import com.infinity.commerce.smart_vyapar.repository.ProductRepository;
    import com.infinity.commerce.smart_vyapar.service.ProductService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;
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

        @GetMapping("/get/all")
        public ResponseEntity<?> getAll(){
            List<Product> productList=productService.getAll();
            if(productList.isEmpty()){
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Empty Inventory");
            }
            return ResponseEntity.status(HttpStatus.OK).body(productList);
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
        //Wrap response in ResponseEntity
        @PutMapping("/update/{id}")
        public ResponseEntity<?> updateById(@PathVariable Long id,@RequestBody Product requestedProduct){
            Product updatedProduct=productService.updateById(id,requestedProduct);
            if(updatedProduct!=null){
                return ResponseEntity.status(HttpStatus.OK).body(updatedProduct);
            }
            else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid Id!");
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
        @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> deleteById(@PathVariable Long id){
            //if it does not exist;
            Product product= productService.deleteById(id);
            if(product!=null){
                return ResponseEntity.status(HttpStatus.OK).body(product);
            }
            else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid Id!");
            }
        }

    }
