//package com.example.apilibreria.factories;
//
//import com.example.apilibreria.models.Libro;
//
//import com.github.javafaker.Faker;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.Locale;
//import java.util.stream.IntStream;
//
//
//@Component
//public class LibroFactory {
//    Faker esFaker = new Faker(new Locale("es-ES"));
//
//    public List<Libro> get(int number) {
//        return IntStream.range(0, number)
//                .mapToObj(x -> new Libro(esFaker.name().firstName(),
//                        esFaker.name().firstName(),
//                        esFaker.name().(1, 12)))
//                .collect(Collectors.toList());
//    }
//}
