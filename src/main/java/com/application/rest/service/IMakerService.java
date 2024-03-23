package com.application.rest.service;

import com.application.rest.entities.Maker;

import java.util.List;
import java.util.Optional;

/*
Clase (Interface) que contiene la logica de la aplicacion o de negocio.
Contiene los mismos metodo que el IMakerDAO.
Esto con la finalidad de crear una arquitectura desacoplada.
 */
public interface IMakerService {

    //Metodos del Crud para los fabricantes.
    //Listar todos los fabricantes.
    List<Maker> findAll();

    //Buscra un fabricante por su id.
    Optional<Maker> findById(Long id);

    //Guardar un nuevo fabicante.
    void save(Maker maker);

    //Eliminar un fabricante pir su id.
    void deleteById(Long id);
}
