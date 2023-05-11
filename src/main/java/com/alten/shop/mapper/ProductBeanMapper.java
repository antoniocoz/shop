package com.alten.shop.mapper;

import org.springframework.stereotype.Component;

import com.alten.shop.bean.ProductBean;
import com.alten.shop.entity.Product;

@Component
public class ProductBeanMapper implements Mapper<ProductBean, Product> {
   
	@Override
	public Product toDoMapping(ProductBean productBean) {
		Product product = new Product();
		if (productBean != null) {
			product.setCategory(productBean.getCategory());
			product.setCode(productBean.getCode());
			product.setDescription(productBean.getDescription());
			product.setId(productBean.getId());
			product.setImage(productBean.getImage());
			product.setInventoryStatus(productBean.getInventoryStatus());
			product.setName(productBean.getName());
			product.setPrice(productBean.getPrice());
			product.setQuantity(productBean.getQuantity());
			product.setRating(productBean.getRating());
		}
		return product;
	}
}
