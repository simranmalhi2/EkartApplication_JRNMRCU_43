package com.ekart.dao;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.ekart.model.Product;

public class ProductDaoImpl implements IProductDao {

	private static Map<Long, Product> products;
	
	
	public ProductDaoImpl() {
		
		if(null == products) {
			products = new HashMap<>();
		}
	}
	
	@Override
	public void addProduct(Product product) { //Adding product details in the map with Id 
		
		products.put(product.getProductId(), product);
		
		
		
	}

	@Override
	public void updateProduct(Long productId, String name, double price, int quantity, Date manufacturedDate, Date expiryDate) {
		
		for(Entry<Long, Product> entry: products.entrySet()) {
			if(entry.getKey() == productId) { //If entered productId is equal to key update the details
		
		Product updateProduct = new Product(productId, name, price, quantity, manufacturedDate, expiryDate );
			updateProduct.setName(name);
			updateProduct.setPrice(price);
			updateProduct.setQuantity(quantity);
			updateProduct.setManufacturedDate(manufacturedDate);
			updateProduct.setExpiryDate(expiryDate);
				
			}
		}
	}

	@Override 
	public void delete(Long productId) {
		 
		//Removing the product from the list
		products.remove(new Long(productId));

	}

	@Override
	public Product getProduct(Long productId) {
		
		return products.get(new Long(productId));
		
	}

	@Override
	public List<Product> getAllProduct() {
		
		ArrayList<Product> list = new ArrayList<>();
		
		Collection<Product> productList = products.values();
		
		for(Product p : productList) {
			list.add(p);
		}
		return list;
	}

}
	
	
	
