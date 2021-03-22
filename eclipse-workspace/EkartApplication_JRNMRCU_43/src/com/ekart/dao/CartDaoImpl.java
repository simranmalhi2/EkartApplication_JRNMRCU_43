package com.ekart.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.ekart.model.Product;

public class CartDaoImpl implements ICartDao {
	
	public CartDaoImpl() {
		
		if(null == userCart) {
			userCart = new HashMap<>();
		}
	}
	//The userCart map is created to add product items in the cart
	private static Map<Long, List<Product>> userCart;

	@Override
	public void addProductsToCart(Long customerId, Long productId) {
		
		ProductDaoImpl productDao = new ProductDaoImpl(); //Instantiating the ProductDaoImpl class to get the products
		
		
		if(userCart.containsKey(customerId)){ //If the customerId is present in cart then add product from the list
			
			List<Product> productList = new ArrayList<Product>();
			
			productList.add(productDao.getProduct(productId)); //Get product from product Dao layer
		
			userCart.put(customerId, productList); //Adding the product in hashmap
		}

	}

	@Override
	public Collection<List<Product>> viewCart(Long customerId)  {
		
		if(userCart.containsKey(customerId)) {  //If the cart has customerId as key, display the list of products in values
			return userCart.values();
	
}
		else
			return null;
}
}