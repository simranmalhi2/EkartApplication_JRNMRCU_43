package com.ekart.dao;

import java.util.Date;
import java.util.List;
import com.ekart.model.*;

public interface IProductDao {

	void addProduct(Product product);

	void updateProduct(Long productId, String name, double price, int quantity, Date manufacturedDate, Date expiryDate);

	void delete(Long productId);
	
	Product getProduct(Long productId);

	 List<Product> getAllProduct();


	
}
