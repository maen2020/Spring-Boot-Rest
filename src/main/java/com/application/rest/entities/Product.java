package com.application.rest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter //Generar Getters
@Setter //Generar Setters
@Builder //
@AllArgsConstructor //Constructor con parametros.
@NoArgsConstructor //Constructor vacio.
@Entity //Entidad.
@Table(name = "producto") //Nombre de la tabla de la base de datos.
public class Product {

    //Atributos.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre") //Nombre de la columna con el que identifica del lado de la base de datos.
    private String name;

    @Column(name = "precio")
    private BigDecimal price;

    /* Relacionar las tablas Maker y Product (1,N)
     * JoinColumn = Nombre de la clave foranea que se va a crear para la relacion.
     * Nullable = Para que siempre exista la relacion.
     * JsonIgnore = Ignorar la serializacion.
     */
    @ManyToOne
    @JoinColumn(name = "id_fabricante", nullable = false)
    @JsonIgnore
    private Maker maker;
}
