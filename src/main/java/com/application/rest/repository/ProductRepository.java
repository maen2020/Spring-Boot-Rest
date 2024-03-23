package com.application.rest.repository;

import com.application.rest.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//Clase(Interface) que permite acceder a las funconalidades de CrudRepository de Jpa.
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}