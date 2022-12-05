package com.example.cykelrytter.services;
import com.example.cykelrytter.model.Image;
import com.example.cykelrytter.repositories.ImageRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Service
public class ImageService implements IImageService{

    private ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public Set<Image> findAll() {
        Set<Image> images = new HashSet<>();
        imageRepository.findAll().forEach(images::add);
        return images;
    }

    @Override
    public Image save(Image object) {
        return imageRepository.save(object);
    }

    @Override
    public void delete(Image object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Optional<Image> findById(Long aLong) {
        return Optional.empty();
    }
}
