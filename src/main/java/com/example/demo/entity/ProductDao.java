package com.example.demo.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProductDao implements Serializable{
	
	Long productId;
	String productName;
	String productDesc;
	Double productQty;
	Double productPrice;

}
