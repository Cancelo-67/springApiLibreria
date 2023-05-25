package com.example.apilibreria.repositories;

import com.example.apilibreria.models.Image;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageRepository extends MongoRepository<Image, String> {
}
