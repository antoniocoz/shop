package com.alten.shop.repository;

import org.springframework.data.repository.CrudRepository;

import com.alten.shop.entity.Product;

/**
 * Repository pour gerer les products
 * @author antonio
 *
 */
public interface ProductRepository extends CrudRepository<Product, Long > {
}
