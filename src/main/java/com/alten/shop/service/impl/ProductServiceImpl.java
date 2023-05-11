package com.alten.shop.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alten.shop.bean.ProductBean;
import com.alten.shop.entity.Product;
import com.alten.shop.exception.TechnicalShopException;
import com.alten.shop.mapper.Mapper;
import com.alten.shop.repository.ProductRepository;
import com.alten.shop.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService  {
    
	@Autowired 
	private ProductRepository productRepository;
	
	@Autowired
	private Mapper<Product, ProductBean> productMapper;
	
	@Autowired
	private Mapper<ProductBean, Product> productBeanMapper;
	
	@Override
	public List<ProductBean> getAll() {
		List<Product> products = StreamSupport.stream(productRepository.findAll().spliterator(), false).collect(Collectors.toList());
		return products.stream().map(productMapper::toDoMapping).collect(Collectors.toList());
	}
	
	@Override
	public ProductBean getById(Long id) throws TechnicalShopException {
		ProductBean productBean = null;
		Optional<Product> opProduct = productRepository.findById(id);
		if (opProduct.isPresent()) {
			productBean = productMapper.toDoMapping(opProduct.get());
		} else {
			throw new TechnicalShopException("le product {} n'est pas dans la base de donnees");
		}
		return productBean;
	}
	
	@Override
	public void save(ProductBean productBean) {
		productRepository.save(productBeanMapper.toDoMapping(productBean));
	}
	
	@Override
	public void delete(Long id) {
		productRepository.deleteById(id);
	}
	
}
