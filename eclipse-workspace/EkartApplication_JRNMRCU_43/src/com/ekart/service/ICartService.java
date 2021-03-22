package com.ekart.service;


import java.util.Collection;
import java.util.List;
import com.ekart.model.Product;

public interface ICartService {

	boolean addProductsToCart(Long customerId, Long productId);

	Collection<List<Product>> viewCart(Long customerId);
}
