package com.example.cykelrytter.services;

import com.example.cykelrytter.model.Image;
import com.example.cykelrytter.repositories.ImageRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ImageServiceTest {

    private ImageService imageService;

    @Autowired
    private ImageRepository imageRepository;

    @BeforeEach
    public void setUp(){
        imageService = new ImageService(imageRepository);
    }

    @Test
    void convertUrl() {
        //ARRANGE
        String url1 = "https://drive.google.com/file/d/1Mqbvd0lFpsM4V83lO9u1aCE9KRP2CPdx/view?usp=share_link"; //Should fail
        String url2 = "https://drive.google.com/uc?export=view&id=1Mqbvd0lFpsM4V83lO9u1aCE9KRP2CPdx"; //Should pass
        //ACT
        Image withParsedUrl1 = imageService.convertUrl(url1);
        //ASSERT
        Assertions.assertNotNull(withParsedUrl1);
        Assertions.assertEquals(url2,withParsedUrl1.getImageURL());
    }
}