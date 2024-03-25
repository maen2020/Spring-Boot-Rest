package com.application.rest.controllers.dto;

import com.application.rest.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/*
Objeto (DTO) que se va a retornar como respuesta dentro del controlador.
Mala practica retorna entidades.
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MakerDTO {

    private Long id;
    private String name;
    private List<Product> productList = new ArrayList<>();
}
