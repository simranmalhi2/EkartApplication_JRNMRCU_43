package com.ekart.dao;


import java.util.Collection;
import java.util.List;

import com.ekart.model.Product;

public interface ICartDao {
	
	void addProductsToCart(Long customerId, Long productId);
	
	Collection<List<Product>> viewCart(Long customerId);

}
