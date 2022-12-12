package com.example.cykelrytter.controllers;

import com.example.cykelrytter.services.IArtistService;
import com.example.cykelrytter.services.IProductService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    private IProductService productService;
    public ProductController(IProductService productService){
        this.productService = productService;
    }



}
