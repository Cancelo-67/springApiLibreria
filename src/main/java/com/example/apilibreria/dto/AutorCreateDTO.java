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
public class AutorCreateDTO implements Serializable {
    @NotNull
    private String nombre;
    @NotNull
    private String primerapellido;
    @NotNull
    private String segundoapellido;

    public AutorCreateDTO() {
    }
}
