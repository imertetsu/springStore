package com.store.backendStore.web.controller;

import com.store.backendStore.domain.Product;
import com.store.backendStore.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping()
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(productService.getAll(), HttpStatusCode.valueOf(200));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int productId){
        Product product = productService.getProductById(productId).orElse(null);
        System.out.println("OPTIONAL PRODUCT: "+ product);
        return product != null
                ? new ResponseEntity<>(product, HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        /*return productService.getProductById(productId)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));*/
        //ResponseEntity.of(productService.getProductById(productId));
    }
    @GetMapping("category/{id}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("id") int categoryId){
        Optional<List<Product>> products = productService.getByCategory(categoryId);
        return !products.isEmpty()
                ? new ResponseEntity<>(products.get(), HttpStatus.OK)
                : new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
    }
    @PostMapping()
    public ResponseEntity<Product> save(@RequestBody Product product){
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") int productId){
        return productService.delete(productId)
                ? new ResponseEntity(HttpStatusCode.valueOf(204))
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
