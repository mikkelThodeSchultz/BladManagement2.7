package com.example.cykelrytter.controllers;

import com.example.cykelrytter.model.Artist;
import com.example.cykelrytter.services.ArtistService;
import com.example.cykelrytter.services.IArtistService;
import com.example.cykelrytter.services.IImageService;
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
    private IImageService imageService;

    public ArtistController(IArtistService artistService, IImageService imageService) {
        this.artistService = artistService;
        this.imageService = imageService;
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

    @PutMapping("/update/artist")
    public ResponseEntity<Artist> update(@RequestBody Artist artist){
        Artist artistToUpdate = artistService.findById(artist.getId()).get();
        if (!artist.getImageLink().equals(artistToUpdate.getImageLink())) {
            String artistImageUrlToSave = imageService.convertUrl(artist.getImageLink());
            artistToUpdate.setImageLink(artistImageUrlToSave);
        } else {
            artistToUpdate.setImageLink(artist.getImageLink());
        }
        artistToUpdate.setAgent(artist.getAgent());
        artistToUpdate.setYoutubeLink(artist.getYoutubeLink());
        artistToUpdate.setFacebookLink(artist.getFacebookLink());
        artistToUpdate.setInstagramLink(artist.getInstagramLink());
        artistToUpdate.setSpotifyLink(artist.getSpotifyLink());
        artistToUpdate.setTikTokLink(artist.getTikTokLink());
        return new ResponseEntity<>(artistService.save(artistToUpdate), HttpStatus.OK);
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
