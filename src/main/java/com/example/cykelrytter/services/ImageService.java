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
    public Image convertUrl(String url){

        //Get first half of url
        String[] urlToArray = url.split("file");

        //Isolate the id og the img
        String[] getIdOfImg = urlToArray[1].split("/");
        urlToArray[1] = "uc?export=view&id=" + getIdOfImg[2];

        //Make one array - merge!
        String converted = urlToArray[0] + urlToArray[1];
        System.out.println(converted);

        Image image = new Image();
        image.setImageURL(converted);

        return imageRepository.save(image);
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
