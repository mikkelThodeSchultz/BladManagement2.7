package com.example.cykelrytter.controllers;

import com.example.cykelrytter.model.Artist;
import com.example.cykelrytter.services.IArtistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
@CrossOrigin
@RestController
public class ArtistController {

    private IArtistService artistService;
    public ArtistController(IArtistService artistService){
        this.artistService = artistService;
    }

    @GetMapping("/get/artistList")
    public ResponseEntity<Set<Artist>> getArtists(){
        return new ResponseEntity<>(artistService.findAll(), HttpStatus.OK);
    }

}
