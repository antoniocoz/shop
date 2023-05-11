package com.alten.shop.mapper;

import org.springframework.stereotype.Component;

import com.alten.shop.bean.ProductBean;
import com.alten.shop.entity.Product;

@Component
public class ProductMapper implements Mapper<Product, ProductBean> {

	@Override
	public ProductBean toDoMapping(Product product) {
		ProductBean productBean = new ProductBean();
		if (product != null) {
			productBean.setCategory(product.getCategory());
			productBean.setCode(product.getCode());
			productBean.setDescription(product.getDescription());
			productBean.setId(product.getId());
			productBean.setImage(product.getImage());
			productBean.setInventoryStatus(product.getInventoryStatus());
			productBean.setName(product.getName());
			productBean.setPrice(product.getPrice());
			productBean.setQuantity(product.getQuantity());
			productBean.setRating(product.getRating());
		}
		return productBean;
	}
}
