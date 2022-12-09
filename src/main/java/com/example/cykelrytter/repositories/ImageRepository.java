package com.example.cykelrytter.repositories;

import com.example.cykelrytter.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image,Long> {
    //String saveUrl(String imageURL);
}
