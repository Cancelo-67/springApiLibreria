package com.example.apilibreria.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;


@Entity
@Setter
@Getter
public class Autor {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String nombre;
    @NotNull
    private String primerapellido;
    @NotNull
    private String segundoapellido;
    @NotNull
    private String imagen;

    //De uno a muchos a autoresylibros
    @JsonBackReference
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private Set<Autoresylibros> autoresylibros = new HashSet<Autoresylibros>();

    //Constructor por defecto
    public Autor() {}

    public Autor(@NotNull String nombre, @NotNull String primerapellido, @NotNull String segundoapellido, @NotNull String imagen) {
        this.nombre = nombre;
        this.primerapellido = primerapellido;
        this.segundoapellido = segundoapellido;
        this.imagen = imagen;
    }
}
