package com.application.rest.persistence.impl;

import com.application.rest.entities.Maker;
import com.application.rest.persistence.IMakerDAO;
import com.application.rest.repository.MakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/*Clase para implementar la interface IMakerDAO de la capa de persistencia.
Definir esta clase como componente.
*/
@Component
public class MakerDAOImpl implements IMakerDAO {

    //Inyectar el repositorio MakerRepository.
    @Autowired
    private MakerRepository makerRepository;

    //Listar todos los fabricantes.
    @Override
    public List<Maker> findAll() {
        return (List<Maker>) makerRepository.findAll();
    }

    //Buscar un fabricante por su id.
    @Override
    public Optional<Maker> findById(Long id) {
        return makerRepository.findById(id);
    }

    //Guardar un nuevo fabricate.
    @Override
    public void save(Maker maker) {
        makerRepository.save(maker);
    }

    //Eliminar un fabricante por su id.
    @Override
    public void deleteById(Long id) {
        makerRepository.deleteById(id);
    }
}
