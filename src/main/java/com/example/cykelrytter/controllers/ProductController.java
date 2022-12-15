package com.example.cykelrytter.controllers;

import com.example.cykelrytter.model.Product;
import com.example.cykelrytter.services.IArtistService;
import com.example.cykelrytter.services.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin
public class ProductController {
    private IProductService productService;
    public ProductController(IProductService productService){
        this.productService = productService;
    }

    @GetMapping("/get/productList")
    public ResponseEntity<Set<Product>> getProducts(){
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping ("/get/product")
    public ResponseEntity<Product> getProduct(@RequestParam Long productId){
        Optional<Product> targetProduct = productService.findById(productId);
        if (targetProduct.isPresent()){
        return new ResponseEntity<>(targetProduct.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/create/product")
    public ResponseEntity<Product> create(@RequestBody Product product){
        return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
    }


}
