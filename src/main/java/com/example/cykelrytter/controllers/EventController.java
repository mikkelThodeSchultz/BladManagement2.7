package com.example.cykelrytter.controllers;

import com.example.cykelrytter.model.Event;
import com.example.cykelrytter.model.Image;
import com.example.cykelrytter.services.IArtistService;
import com.example.cykelrytter.services.IEventService;
import com.example.cykelrytter.services.IImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin
@RestController
public class EventController {
    private IEventService eventService;
    private IImageService imageService;

    public EventController(IEventService eventService, IImageService imageService) {
        this.eventService = eventService;
        this.imageService = imageService;
    }

    @GetMapping("/get/allEvents")
    public ResponseEntity<Set<Event>> getAll(){
        return new ResponseEntity<>(eventService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create/event")
    public ResponseEntity<Event> create(@RequestBody Event event){
        String eventUrl = event.getImageUrl();
        String eventImageUrlToSave = imageService.convertUrl(eventUrl);
        event.setImageUrl(eventImageUrlToSave);
        return new ResponseEntity<>(eventService.save(event), HttpStatus.OK);
    }

    @PutMapping("/update/event")
    public ResponseEntity<Event> update(@RequestBody Event event){
        Event eventToUpdate = eventService.findById(event.getId()).get();
        eventToUpdate.setDate(event.getDate());
        if (!event.getImageUrl().equals(eventToUpdate.getImageUrl())) {
            String eventImageUrlToSave = imageService.convertUrl(event.getImageUrl());
            eventToUpdate.setImageUrl(eventImageUrlToSave);
        }
        eventToUpdate.setDescription(event.getDescription());
        eventToUpdate.setFacebookLink(event.getFacebookLink());
        return new ResponseEntity<>(eventService.save(eventToUpdate), HttpStatus.OK);
    }

    @DeleteMapping("/delete/event/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long eventId){
        if (eventService.findById(eventId).isPresent()){
            eventService.deleteById(eventId);
            return new ResponseEntity<>("Event deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to delete event", HttpStatus.OK);
        }
    }
}
