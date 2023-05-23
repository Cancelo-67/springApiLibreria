package com.example.apilibreria.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

//Con entity declaro que es un modelo.
@Entity
@Setter
@Getter
public class Libro {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String titulo;
    @NotNull
    private String nombreautor;
    @NotNull
    private String imagen;
    @NotNull
    @Column(length = 1500)
    private String descripcion;
    @NotNull
    private Integer año;

    //De uno a muchos a autoreslibros
    @JsonBackReference
    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL)
    private Set<Autoresylibros> autoresylibros = new HashSet<Autoresylibros>();


    //Constructor por defecto
    public Libro() {

    }
    //Constructor con todos los campos


    public Libro(@NotNull String titulo, @NotNull String nombreautor, @NotNull String imagen, @NotNull String descripcion, @NotNull Integer año) {
        this.titulo = titulo;
        this.nombreautor = nombreautor;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.año = año;
    }
}
