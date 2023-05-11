package com.alten.shop;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.alten.shop.entity.Product;
import com.alten.shop.repository.ProductRepository;


/**
 * classe main shop
 * @author antonio
 *
 */
@SpringBootApplication
public class ShopApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(ShopApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}
	
	/**
	 * Methode pour initializer le repository 
	 * @param repository
	 * @return
	 */
    @Bean
	public CommandLineRunner initData(ProductRepository repository) {
	    return (args) -> {
	      // save products
	      repository.saveAll(this.getProducts());
	      // fetch all customers
	      logger.info("Product found with findAll ():");
	      logger.info("-------------------------------");
	      repository.findAll().forEach( (product) -> {
	    	  logger.info("code :{}", product.getCode());
	      });
	    };
	}
    
    /**
     * Methode qui retourner des products 
     * @return liste des products
     */
	private List<Product> getProducts() {
		List<Product> products = new ArrayList<>();
		Product product = new Product();
		product.setCategory("Accessories");
		product.setCode("f230fh0g3");
		product.setDescription("Product Description");
		product.setName("Bamboo Watch");
		product.setPrice(65.0);
		product.setImage("bamboo-watch.jpg");
		product.setInventoryStatus("INSTOCK");
		product.setQuantity(24);
		product.setRating(5);
		
		Product product1 = new Product();
		product1.setCategory("Accessories");
		product1.setCode("nvklal433");
		product1.setDescription("Product Description");
		product1.setName("Black Watch");
		product1.setPrice(72.0);
		product1.setImage("black-watch.jpg");
		product1.setInventoryStatus("INSTOCK");
		product1.setQuantity(61);
		product1.setRating(4);
		
		Product product3 = new Product();
		product3.setCategory("Fitness");
		product3.setCode("zz21cz3c1");
		product3.setDescription("Product Description");
		product3.setName("Blue Band");
		product3.setPrice(79.0);
		product3.setImage("blue-band.jpg");
		product3.setInventoryStatus("inventory");
		product3.setQuantity(2);
		product3.setRating(3);
		
		products.add(product);
		products.add(product1);
		products.add(product3);
		return products;
	}
}
