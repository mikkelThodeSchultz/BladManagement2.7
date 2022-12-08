package com.example.cykelrytter.controllers;

import com.example.cykelrytter.model.Event;
import com.example.cykelrytter.services.IArtistService;
import com.example.cykelrytter.services.IEventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class EventController {
    private IEventService eventService;
    public EventController(IEventService eventService){
        this.eventService = eventService;
    }

    @GetMapping("/get/allEvents")
    public ResponseEntity<Set<Event>> getAll(){
        return new ResponseEntity<>(eventService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create/event")
    public ResponseEntity<Event> create(@RequestBody Event event){
        return new ResponseEntity<>(eventService.save(event), HttpStatus.OK);
    }
}
