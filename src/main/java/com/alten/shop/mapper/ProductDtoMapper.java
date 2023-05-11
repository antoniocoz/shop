package com.alten.shop.mapper;

import org.springframework.stereotype.Component;

import com.alten.shop.bean.ProductBean;
import com.alten.shop.dto.ProductDto;

@Component
public class ProductDtoMapper implements Mapper<ProductBean, ProductDto> {
	   
		@Override
		public ProductDto toDoMapping(ProductBean productBean) {
			ProductDto productDto = new ProductDto();
			if (productBean != null) {
				productDto.setCategory(productBean.getCategory());
				productDto.setCode(productBean.getCode());
				productDto.setDescription(productBean.getDescription());
				productDto.setId(productBean.getId());
				productDto.setImage(productBean.getImage());
				productDto.setInventoryStatus(productBean.getInventoryStatus());
				productDto.setName(productBean.getName());
				productDto.setPrice(productBean.getPrice());
				productDto.setQuantity(productBean.getQuantity());
				productDto.setRating(productBean.getRating());
			}
			return productDto;
		}
		
		public ProductBean toDoMapping(ProductDto productDto) {
			ProductBean productBean = new ProductBean();
			if (productDto != null) {
				productBean.setCategory(productDto.getCategory());
				productBean.setCode(productDto.getCode());
				productBean.setDescription(productDto.getDescription());
				productBean.setId(productDto.getId());
				productBean.setImage(productDto.getImage());
				productBean.setInventoryStatus(productDto.getInventoryStatus());
				productBean.setName(productDto.getName());
				productBean.setPrice(productDto.getPrice());
				productBean.setQuantity(productDto.getQuantity());
				productBean.setRating(productDto.getRating());
			}
			return productBean;
		}
	}
