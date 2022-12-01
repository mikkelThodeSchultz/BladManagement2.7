package com.example.cykelrytter.controllers;

import com.example.cykelrytter.model.Artist;
import com.example.cykelrytter.services.ArtistService;
import com.example.cykelrytter.services.IArtistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
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

    @GetMapping("/get/artist")
    public ResponseEntity<Artist> getArtist(@RequestParam Long artistID){
        Optional<Artist> artistToGet = artistService.findById(artistID);
        if (artistToGet.isPresent()){
            return new ResponseEntity<>(artistToGet.get(), HttpStatus.OK);
        }
        else return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
}
