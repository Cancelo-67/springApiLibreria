package com.example.apilibreria.dto;

import com.example.apilibreria.models.Autor;
import com.example.apilibreria.models.Autoresylibros;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AutorDTO implements Serializable {
    private Long id;
    private String nombre;
    private String primerapellido;
    private String segundoapellido;
    private String imagen;
    private List<String> libros;

    public AutorDTO(Autor autor){
        this.id = autor.getId();
        this.nombre = autor.getNombre();
        this.primerapellido = autor.getPrimerapellido();
        this.segundoapellido = autor.getSegundoapellido();
        this.libros = new ArrayList<>();
        for (Autoresylibros autoresylibros: autor.getAutoresylibros()) {
            libros.add(autoresylibros.getLibro().getTitulo());
        }
    }
}
