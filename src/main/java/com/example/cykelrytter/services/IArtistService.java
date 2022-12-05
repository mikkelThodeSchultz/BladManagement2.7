package com.example.cykelrytter.services;


import com.example.cykelrytter.model.Artist;

import java.util.List;
import java.util.Optional;

public interface IArtistService extends ICrudService<Artist,Long> {

    List<Artist> findArtistByName(String artistName);
}
