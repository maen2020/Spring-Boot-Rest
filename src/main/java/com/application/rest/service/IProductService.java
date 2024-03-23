package com.application.rest.service;

import com.application.rest.entities.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/*
Clase (Interface) que contiene la logica de la aplicacion o de negocio.
Contiene los mismos metodo que el IProductDAO.
Esto con la finalidad de crear una arquitectura desacoplada.
 */
public interface IProductService {

    //Metodos del CrudRepository para el producto.
    //Obtener todos los productos.
    List<Product> findAll();

    //Consultar todos los productos.
    Optional<Product> findById(Long id);

    /* QueryMethod
    Obtener una lista de precios por un rango.
    */
    List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice);

    //Guardar un nuevo producto.
    void save(Product product);

    //Emilinar un producto por su id.
    void deleteById(Long id);
}
