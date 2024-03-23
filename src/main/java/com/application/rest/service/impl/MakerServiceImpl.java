package com.application.rest.service.impl;

import com.application.rest.entities.Maker;
import com.application.rest.persistence.IMakerDAO;
import com.application.rest.service.IMakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
Clase que implementa la clase de Servicio IMakerService.
 */
@Service
public class MakerServiceImpl implements IMakerService {

    //Inyectar la interface IMakerDAO
    @Autowired
    private IMakerDAO makerDAO;
    @Override
    public List<Maker> findAll() {
        return makerDAO.findAll();
    }

    @Override
    public Optional<Maker> findById(Long id) {
        return makerDAO.findById(id);
    }

    @Override
    public void save(Maker maker) {
        makerDAO.save(maker);
    }

    @Override
    public void deleteById(Long id) {
        makerDAO.deleteById(id);
    }
}
