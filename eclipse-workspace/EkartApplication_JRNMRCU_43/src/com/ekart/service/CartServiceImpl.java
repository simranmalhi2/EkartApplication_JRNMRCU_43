package com.ekart.service;

import java.util.Collection;
import java.util.List;

import com.ekart.dao.CartDaoImpl;
import com.ekart.dao.ICartDao;
import com.ekart.model.Product;

public class CartServiceImpl implements ICartService {

	private static ICartDao cartDao;
	
public CartServiceImpl() {
		
		if (null == cartDao) {
			cartDao = new CartDaoImpl();
		}
	}
	
	@Override
	public boolean addProductsToCart(Long customerId, Long productId) {
		
		
		cartDao.addProductsToCart(customerId, productId);
		Collection<List<Product>> savedCart = cartDao.viewCart(customerId);
		
		if(savedCart != null) { //If cart is not null return true
			return true;
		}
		else
			return false;
	}


	@Override
	public Collection<List<Product>> viewCart(Long customerId) {
		
		return cartDao.viewCart(customerId);
	}

}
