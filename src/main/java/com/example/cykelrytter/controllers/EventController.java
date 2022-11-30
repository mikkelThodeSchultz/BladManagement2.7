package com.example.cykelrytter.controllers;

import com.example.cykelrytter.services.IArtistService;
import com.example.cykelrytter.services.IEventService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {
    private IEventService eventService;
    public EventController(IEventService eventService){
        this.eventService = eventService;
    }
}
