package com.example.cykelrytter.controllers;

import com.example.cykelrytter.model.Image;
import com.example.cykelrytter.services.IImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin
@RestController
public class ImageController {

    private IImageService imageService;

    public ImageController(IImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/get/allBackstageImages")
    public ResponseEntity<Set<Image>> getAll(){
        return new ResponseEntity<>(imageService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create/backstageImage")
    public ResponseEntity<Image> create (@RequestBody Image imageUrl){
        return new ResponseEntity<>(imageService.save(imageUrl), HttpStatus.OK);
    }

    @PostMapping("/create/urlParsed")
    public ResponseEntity<String> saveUrl (@RequestParam String url){
        return new ResponseEntity<>(imageService.convertUrl(url), HttpStatus.OK);
    }
}
