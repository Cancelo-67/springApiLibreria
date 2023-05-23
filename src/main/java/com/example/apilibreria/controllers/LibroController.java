package com.example.apilibreria.controllers;

import com.example.apilibreria.models.Libro;
import com.example.apilibreria.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class LibroController {

    @Autowired
    LibroRepository libroRepository;

    @GetMapping("/libros/")
    ResponseEntity<Object> index() {
        return new ResponseEntity<>(libroRepository.findAll() , HttpStatus.OK);
    }

    @GetMapping("/libros/{id}/")
    public ResponseEntity<Object> show(@PathVariable("id") Long id) {
        return new ResponseEntity<>(libroRepository.findById(id) , HttpStatus.OK);
    }

    @PostMapping("/libros/")
    public ResponseEntity<Object> create(@RequestBody Libro libro) {
        libroRepository.save(libro);
        return new ResponseEntity<>(libro, HttpStatus.OK);
    }
    @DeleteMapping("/libros/{id}/")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        Optional<Libro> libro = libroRepository.findById(id);
        libro.ifPresent(value -> libroRepository.delete(value));
        return new ResponseEntity<>(libro.isPresent(), HttpStatus.OK);
    }   
    @PutMapping("/libros/{id}/")
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody Libro libro) {
        Optional<Libro> oldLibro = libroRepository.findById(id);
        if (oldLibro.isPresent()) {
            libro.setId(id);
            libroRepository.save(libro);
            return new ResponseEntity<>(libro, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
