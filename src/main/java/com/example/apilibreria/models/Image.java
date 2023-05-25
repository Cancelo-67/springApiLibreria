package com.example.apilibreria.models;


import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "images")
@Getter@Setter@NoArgsConstructor@AllArgsConstructor
public class Image {
    @Id
    private String id;

    private String title;

    private Binary image;

    public Image(String title) {
        this.title = title;
    }
}
