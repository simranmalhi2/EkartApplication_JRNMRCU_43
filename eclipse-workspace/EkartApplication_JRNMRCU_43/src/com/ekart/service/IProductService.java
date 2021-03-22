package com.ekart.service;

import java.util.Date;
import java.util.List;

import com.ekart.model.Product;

public interface IProductService {

	boolean addProduct(Product product);

	boolean updateProduct(Long productId, String name, double price, int quantity, Date manufacturedDate, Date expiryDate);

	boolean deleteProduct(Long productId);
	
	Product getProduct(Long productId);

	 List<Product> getAllProduct();
	 
	 
}
