package com.example.apilibreria.bootstrap;

import com.example.apilibreria.factories.AutorFactory;
import com.example.apilibreria.factories.LibroFactory;
import com.example.apilibreria.models.Autor;
import com.example.apilibreria.models.Autoresylibros;
import com.example.apilibreria.models.Libro;
import com.example.apilibreria.models.User;
import com.example.apilibreria.repositories.AutoresyLibrosRepository;
import com.example.apilibreria.repositories.AutorRepository;
import com.example.apilibreria.repositories.LibroRepository;
import com.example.apilibreria.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Seeder implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;
    @Autowired
    LibroRepository libroRepository;
    @Autowired
    LibroFactory libroFactory;
    @Autowired
    AutoresyLibrosRepository autoresyLibrosRepository;
    @Autowired
    AutorRepository autorRepository;
    @Autowired
    AutorFactory autorFactory;

    @Override
    public void run(String... args) throws Exception{
        //Usuarios
        User usuario1 = new User("alejandro", "alex", true);
        User usuario2 = new User("gon", "zalo", false);
        userRepository.save(usuario1);
        userRepository.save(usuario2);
        //Libro de prueba
        Libro l1 = libroRepository.save(new Libro("Titulo1", "Alejandro", "imagen prueba", "descripcion 1", 2001));
        Libro l2 = libroRepository.save(new Libro("Mi libro", "Alejandro", "imagen prueba", "descripcion de mi libro", 2001));
        List<Libro> libros = libroFactory.get(8);
        libroRepository.saveAll(libros);
        //Autor de prueba
        Autor a1 = autorRepository.save(new Autor("Alejandro","Cancelo","Hurtado","prueba imagen"));
        List<Autor> autores = autorFactory.get(9);
        autorRepository.saveAll(autores);
        Autoresylibros e1 = new Autoresylibros(a1, l1);
        autoresyLibrosRepository.save(e1);
    }
}