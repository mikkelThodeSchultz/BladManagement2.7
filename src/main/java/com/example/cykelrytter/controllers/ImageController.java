package com.example.cykelrytter.controllers;

import com.example.cykelrytter.services.IArtistService;
import com.example.cykelrytter.services.IImageService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {
    private IImageService imageService;
    public ImageController(IImageService imageService){
        this.imageService = imageService;
    }
}
