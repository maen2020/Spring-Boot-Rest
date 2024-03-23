package com.application.rest.persistence.impl;

import com.application.rest.entities.Product;
import com.application.rest.persistence.IProductDAO;
import com.application.rest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/*Clase para implementar la interface IProductDAO de la capa de persistencia.
Definir esta clase como componente.
*/
@Component
public class ProductDAOimpl implements IProductDAO {

    //Inyectar el repositorio de ProductRepository.
    @Autowired
    private ProductRepository productRepository;

    //Obtene todos los productos.
    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    //Buscar un producto por su id.
    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    //Buscar productos por un rango de precios.
    @Override
    public List<Product> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return productRepository.findProductByPriceInRange(minPrice, maxPrice);
    }

    //Guardar un nuevo producto.
    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    //Eliminar un producto por su id.
    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
