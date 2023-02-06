package com.example.apilibreria.repositories;

import com.example.apilibreria.models.Libro;
import org.springframework.data.repository.CrudRepository;

public interface LibroRepository extends CrudRepository<Libro, Long> {

}
