package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ProductDao;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/products")
	public ResponseEntity<Object> getProducts(){
		List<ProductDao> listProducts = productService.getProducts();
		if(listProducts.isEmpty())
			return new ResponseEntity<Object>("No products exist in system",HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<Object>(listProducts, HttpStatus.OK);
		
	}
	
	@PostMapping("/product")
	public ProductDao addProduct(@RequestBody ProductDao product){
		ProductDao prod = productService.addProduct(product);
		return prod;
		
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Object> getProductById(@PathVariable("id") Long id) {
		ProductDao prod = productService.getProductById(id);
		if(prod == null )
			return new ResponseEntity<Object>("Product doesn't exist",HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<Object>(prod,HttpStatus.OK);
	}
	
	@PutMapping("/product")
	public ProductDao updateProduct(@RequestBody ProductDao product) {
		ProductDao pr = productService.updateProduct(product);
		return pr;
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable("id") Long id) {
		ProductDao pr = productService.deleteProduct(id);
		if(pr == null)
			 return new ResponseEntity<Object>("Product doesn't exist",HttpStatus.BAD_REQUEST);
		else
			 return new ResponseEntity<Object>(pr,HttpStatus.OK);
	}
	
	

}
