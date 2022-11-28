package com.example.cykelrytter.repositories;

import com.example.cykelrytter.model.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiderRepository extends JpaRepository<Rider,Long> {
}
