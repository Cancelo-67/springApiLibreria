package com.example.apilibreria.controllers;

import com.example.apilibreria.dto.AutorDTO;
import com.example.apilibreria.models.Autor;
import com.example.apilibreria.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class AutorController {

    @Autowired
    AutorRepository autorRepository;

    @GetMapping("/autor/")
    ResponseEntity<Object> index() {
        List<AutorDTO> resultado = new ArrayList<>();
        for (Autor autor: autorRepository.findAll()) {
            resultado.add(new AutorDTO(autor));
        }
        return new ResponseEntity<>(resultado , HttpStatus.OK);
    }

    @GetMapping("/autor/{id}/")
    public ResponseEntity<Object> show(@PathVariable("id") Long id) {
        Autor autor = autorRepository.findById(id).get();
        return new ResponseEntity<>( new AutorDTO(autor), HttpStatus.OK);
    }

    @PostMapping("/autor/")
    public ResponseEntity<Object> create(@RequestBody Autor autor) {
        autorRepository.save(autor);
        return new ResponseEntity<>(autor, HttpStatus.OK);
    }
    @DeleteMapping("/autor/{id}/")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        Optional<Autor> autor = autorRepository.findById(id);
        autor.ifPresent(value -> autorRepository.delete(value));
        return new ResponseEntity<>(autor.isPresent(), HttpStatus.OK);
    }
    @PutMapping("/autor/{id}/")
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody Autor autor) {
        Optional<Autor> oldAutor = autorRepository.findById(id);
        if (oldAutor.isPresent()) {
            autor.setId(id);
            autorRepository.save(autor);
            return new ResponseEntity<>(autor, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
