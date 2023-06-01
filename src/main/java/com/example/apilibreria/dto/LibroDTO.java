package com.example.apilibreria.dto;


import com.example.apilibreria.models.Autoresylibros;
import com.example.apilibreria.models.Libro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LibroDTO implements Serializable {
    private Long id;
    private String titulo;
    private String nombreautor;
    private String imagen;
    private String descripcion;
    private String año;
    private String genero;
    private String editorial;
    private Double precio;
    private Integer cantidad;
    private List<String> autores;


    public LibroDTO(Libro libro){
        this.id = libro.getId();
        this.titulo = libro.getTitulo();
        this.nombreautor = libro.getNombreautor();
        this.imagen = libro.getImagen();
        this.descripcion = libro.getDescripcion();
        this.año = String.valueOf(libro.getAño());
        this.genero = libro.getGenero();
        this.editorial = libro.getEditorial();
        this.precio = libro.getPrecio();
        this.cantidad = libro.getCantidad();
        for (Autoresylibros autoresylibros: libro.getAutoresylibros()){
            autores.add(autoresylibros.getAutor().getNombre());
        }
    }
}
