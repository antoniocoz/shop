package com.alten.shop.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.alten.shop.dto.ProductDto;
import com.alten.shop.exception.TechnicalShopException;
import com.alten.shop.mapper.ProductDtoMapper;
import com.alten.shop.service.ProductService;

/**
 * API REST pour gerer les products
 * @author antonio
 *
 */
@RestController
public class ProductRest {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductDtoMapper productDtoMapper;  
	
	@GetMapping("/products")
	public List<ProductDto> getAll() {
		return productService.getAll().stream().map(productDtoMapper::toDoMapping).collect(Collectors.toList());
	}
	
	@GetMapping("/products/{id}")
	public ProductDto getProductById(@PathVariable Long id) {
		ProductDto productDto =null;
		 try {
			 productDto = productDtoMapper.toDoMapping(productService.getById(id));
		} catch (TechnicalShopException e) {
			throw new ResponseStatusException(
			           HttpStatus.NOT_FOUND, e.getMessage(), e);
		}
		return productDto; 
	}
	
	@PostMapping("/products")
	public void save(@RequestBody ProductDto productDto) {
		productService.save(productDtoMapper.toDoMapping(productDto));
	}
	
	@PutMapping("/products")
	public void update(@RequestBody ProductDto productDto) {
	    productService.save(productDtoMapper.toDoMapping(productDto));;
	}
	
	@DeleteMapping("/products/{id}")
	public void delete(@PathVariable Long id) {
	   productService.delete(id);
	}

}
