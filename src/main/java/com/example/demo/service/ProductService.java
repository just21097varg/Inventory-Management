package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ProductDao;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;

	public List<ProductDao> getProducts() {
		List<ProductDao> listProds = productRepository.getProducts();
		return listProds;
	}

	public ProductDao addProduct(ProductDao product) {
		return productRepository.addProduct(product);
	}

	public ProductDao getProductById(Long id) {
		
		return productRepository.getProductById(id);
	}

	public ProductDao updateProduct(ProductDao product) {
		
		return productRepository.updateProduct(product);
	}

	public ProductDao deleteProduct(Long id) {
		
		return productRepository.deleteProduct(id);
	}

	
}
