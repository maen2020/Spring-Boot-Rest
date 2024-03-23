package com.application.rest.persistence;

import com.application.rest.entities.Maker;

import java.util.List;
import java.util.Optional;

public interface IMakerDAO {

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
