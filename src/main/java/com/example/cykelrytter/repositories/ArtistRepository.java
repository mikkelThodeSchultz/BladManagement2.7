package com.example.cykelrytter.repositories;

import com.example.cykelrytter.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist,Long> {
}
