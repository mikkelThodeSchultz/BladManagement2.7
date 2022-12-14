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
    public ResponseEntity<Image> create (@RequestBody String imageUrl){
        String urlToSave = imageService.convertUrl(imageUrl);
        Image image = new Image();
        image.setImageURL(urlToSave);
        return new ResponseEntity<>(imageService.save(image), HttpStatus.OK);
    }

    @DeleteMapping ("/delete/backstageImage")
    public ResponseEntity<String> delete (@RequestParam Long imageId){
        imageService.deleteById(imageId);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
