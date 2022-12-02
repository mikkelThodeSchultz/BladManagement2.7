package com.example.cykelrytter.repositories;

import com.example.cykelrytter.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArtistRepository extends JpaRepository<Artist,Long> {
    List<Artist> findArtistByName(String name);
}
