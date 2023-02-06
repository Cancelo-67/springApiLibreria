package com.example.apilibreria.controllers;

import com.example.apilibreria.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutorController {

    @Autowired
    AutorRepository autorRepository;

    @GetMapping("/autor/")
    ResponseEntity<?> index() {
        return new ResponseEntity<>(autorRepository.findAll() , HttpStatus.OK);
    }
}
