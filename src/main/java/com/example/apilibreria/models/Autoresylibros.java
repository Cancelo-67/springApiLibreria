package com.example.apilibreria.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Autoresylibros {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn()
    private Autor autor;
    @ManyToOne
    @JoinColumn()
    private Libro libro;

    public Autoresylibros(Autor autor, Libro libro) {
        this.autor = autor;
        this.libro = libro;
    }
}
