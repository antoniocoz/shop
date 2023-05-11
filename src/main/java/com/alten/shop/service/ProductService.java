package com.alten.shop.service;

import java.util.List;

import com.alten.shop.bean.ProductBean;
import com.alten.shop.exception.TechnicalShopException;

/**
 * Interface pour gerer les products
 * @author antonio
 *
 */
public interface ProductService {
  /**
   * Methode qui retourne une liste des products	
   * @return
   */
  List<ProductBean> getAll();
  /**
   * Methode qui retourne un product by ID
   * @param id
   * @return
   */
  ProductBean getById(Long id) throws TechnicalShopException;
  /**
   * Methode pour enregistre un product
   * @param productBean
   */
  void save(ProductBean productBean);
  /**
   * Methode pour supprimir un product
   * @param id
   */
  void delete(Long id);
}
