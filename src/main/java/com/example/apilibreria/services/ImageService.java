package com.example.apilibreria.services;


import com.example.apilibreria.models.Image;
import com.example.apilibreria.repositories.ImageRepository;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;


    public String addImage(String title, MultipartFile file) throws IOException{
        Image image = new Image(title);
        image.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        image = imageRepository.insert(image);
        return image.getId();
    }

    public Image getImage(String id){
        return imageRepository.findById(id).get();
    }
}
