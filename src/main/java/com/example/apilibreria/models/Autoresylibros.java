package com.example.apilibreria.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
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

}
