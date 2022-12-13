package com.example.cykelrytter.services;

import com.example.cykelrytter.model.Event;
import com.example.cykelrytter.model.Image;
import com.example.cykelrytter.repositories.EventRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Service
public class EventService implements IEventService{

    private EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Set<Event> findAll() {
        Set<Event> events = new HashSet<>();
        eventRepository.findAll().forEach(events::add);
        return events;
    }

    @Override
    public Event save(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public void delete(Event object) {

    }

    @Override
    public void deleteById(Long aLong) {
        eventRepository.deleteById(aLong);
    }

    @Override
    public Optional<Event> findById(Long aLong) {
        return eventRepository.findById(aLong);
    }
}
