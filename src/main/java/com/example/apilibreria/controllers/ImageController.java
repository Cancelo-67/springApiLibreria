package com.example.apilibreria.controllers;


import com.example.apilibreria.models.Image;
import com.example.apilibreria.services.ImageService;
import jakarta.websocket.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@RestController
public class ImageController {
    @Autowired
    ImageService imageService;


    @PostMapping("/images/add")
    public String addImage(@RequestParam("title") String title,
                           @RequestParam("image")MultipartFile image)
        throws IOException {
        return imageService.addImage(title,image);
    }

    public String getImage(@PathVariable String id){
        Image image = imageService.getImage(id);
        return Base64.getEncoder().encodeToString(image.getImage().getData());
    }
}
