package com.application.rest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter //Generar Getters
@Setter //Generar Setters
@Builder //
@AllArgsConstructor //Constructor con parametros.
@NoArgsConstructor //Constructor vacio.
@Entity //Entidad.
@Table(name = "fabricante") //Nombre de la tabla de la base de datos.
public class Maker {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String name;

    /* Relacionar las tablas Maker y Product (1,N)
     * mappedBy = Identificador que se colocara en la tabla Product para hacer la relacion.
     * cascade = Eliminacion de un producto se elimina su creador.
     * FetchType = Poblar la lista cuando se utilice.
     * orphanRemoval = Si se elimina un creador tambien se eliminan sus productos.
    */
    @OneToMany(mappedBy = "maker", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<Product> productList = new ArrayList<>();

}
