package com.example.cykelrytter.services;

import com.example.cykelrytter.model.Artist;
import com.example.cykelrytter.repositories.ArtistRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
@Service
public class ArtistService implements IArtistService{

    private ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public Set<Artist> findAll() {
        return null;
    }

    @Override
    public Artist save(Artist object) {
        return null;
    }

    @Override
    public void delete(Artist object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Optional<Artist> findById(Long aLong) {
        return Optional.empty();
    }
}
