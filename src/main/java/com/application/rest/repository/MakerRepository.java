package com.application.rest.repository;

import com.application.rest.entities.Maker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//Clase(Interface) que permite acceder a las funconalidades de CrudRepository de Jpa.
@Repository
public interface MakerRepository extends CrudRepository<Maker, Long> {
}