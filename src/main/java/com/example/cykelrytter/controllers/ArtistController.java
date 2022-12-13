package com.example.cykelrytter.controllers;

import com.example.cykelrytter.model.Artist;
import com.example.cykelrytter.services.ArtistService;
import com.example.cykelrytter.services.IArtistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
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

    @GetMapping("/get/artistByName")
    public ResponseEntity <List<Artist>> getArtistByName(String artistName){
        if (artistService.findArtistByName(artistName).size()==1) {
            return new ResponseEntity<>(artistService.findArtistByName(artistName), HttpStatus.OK);
        } else return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/create/artist")
    public ResponseEntity<Artist> create(@RequestBody Artist artist){
        return new ResponseEntity<>(artistService.save(artist), HttpStatus.OK);
    }

    @DeleteMapping("/delete/artist/{id}")
    public ResponseEntity<String> delete (@PathVariable("id") Long artistId){
        if (artistService.findById(artistId).isPresent()){
            artistService.deleteById(artistId);
            return new ResponseEntity<>("Artist with id " + artistId, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to delete artist " + artistId, HttpStatus.BAD_REQUEST);
        }
    }
}
