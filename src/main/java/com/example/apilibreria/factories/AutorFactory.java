package com.example.apilibreria.factories;

import com.example.apilibreria.models.Autor;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
public class AutorFactory {
    Faker esFaker = new Faker(new Locale("es-ES"));

    public List<Autor> get(int number) {
        List<Autor> autores = new ArrayList<>();
        for (int i = 0; i < number; i++)
            autores.add(new Autor(
                    esFaker.name().firstName(),
                    esFaker.name().lastName(),
                    esFaker.name().lastName(),
                    "imagen de prueba"));
        return autores;
    }
};
