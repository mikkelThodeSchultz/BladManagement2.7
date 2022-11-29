package com.example.cykelrytter.repositories;

import com.example.cykelrytter.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long> {
}
