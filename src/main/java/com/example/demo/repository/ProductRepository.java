package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ProductDao;

@Repository
public class ProductRepository {
	
	@Autowired
	RedisTemplate redisTemplate;
	
	public static String KEY = "PRODUCTS";

	public List<ProductDao> getProducts() {
		return redisTemplate.opsForHash().values(KEY);
	}

	public ProductDao addProduct(ProductDao product) {
		redisTemplate.opsForHash().put(KEY, product.getProductId(), product);
		return product;
		
	}

	public ProductDao getProductById(Long id) {
		return (ProductDao) redisTemplate.opsForHash().get(KEY, id);
	}

	public ProductDao updateProduct(ProductDao product) {
		redisTemplate.opsForHash().put(KEY, product.getProductId(), product);
		return product;
	}

	public ProductDao deleteProduct(Long id) {
		ProductDao product = (ProductDao) redisTemplate.opsForHash().get(KEY, id);
		if(product != null)
			redisTemplate.opsForHash().delete(KEY, id);
		return product;
	}

}
