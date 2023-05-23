package com.example.apilibreria.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
//Este lo creara el usuario a traves del Cliente
@Getter
@Setter
@AllArgsConstructor
public class LibroCreateDTO implements Serializable {
    @NotNull
    private String titulo;
    @NotNull
    private String nombreautor;

    private String imagen;

    private String descripcion;

    @NotNull
    private Integer año;

    public LibroCreateDTO() {
    }
}
