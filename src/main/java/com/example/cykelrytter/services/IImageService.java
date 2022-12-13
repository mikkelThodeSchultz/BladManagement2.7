package com.example.cykelrytter.services;


import com.example.cykelrytter.model.Image;

public interface IImageService extends ICrudService<Image,Long> {

    Image convertUrl(String url);

}
