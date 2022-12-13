package com.example.cykelrytter.services;

import com.example.cykelrytter.model.Artist;
import com.example.cykelrytter.model.Image;
import com.example.cykelrytter.repositories.ArtistRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
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
        Set<Artist> set =new HashSet<>(artistRepository.findAll());
        return set;
    }

    @Override
    public Artist save(Artist object) {
        return artistRepository.save(object);
    }

    @Override
    public void delete(Artist object) {
        artistRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        artistRepository.deleteById(aLong);
    }

    @Override
    public Optional<Artist> findById(Long aLong) {
        return artistRepository.findById(aLong);
    }


    @Override
    public List<Artist> findArtistByName(String artistName) {
        return artistRepository.findArtistByName(artistName);
    }
}
