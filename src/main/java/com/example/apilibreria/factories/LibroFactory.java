package com.example.apilibreria.factories;

import com.example.apilibreria.models.Libro;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


@Component
public class LibroFactory {
    Faker esFaker = new Faker(new Locale("es-ES"));

    public List<Libro> get(int number) {
        List<Libro> libros = new ArrayList<>();
        for (int i=0;i<number;i++)
            libros.add(new Libro(
                    esFaker.book().title(),
                    esFaker.book().author(),
                    "imagen del Libro",
                    "descripcion",
                    esFaker.number().numberBetween(2000,2022),
                    esFaker.book().genre(),
                    esFaker.book().publisher(),
                    esFaker.number().randomDouble(2,1,50),
                    esFaker.number().numberBetween(1,20)
                    ));

        return libros;
    }
}
