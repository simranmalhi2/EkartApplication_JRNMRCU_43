package com.ekart.service;

import java.util.Date;
import java.util.List;

import com.ekart.dao.IProductDao;
import com.ekart.dao.ProductDaoImpl;
import com.ekart.model.Product;

public class ProductServiceImpl implements IProductService {

	private static IProductDao productDao;
	
	
	public ProductServiceImpl() {
		
		if (null == productDao) {
			productDao = new ProductDaoImpl();
		}
	}
	@Override
	public boolean addProduct(Product product) {
		
		productDao.addProduct(product);
		Product savedProduct = productDao.getProduct(product.getProductId());
		
		if(savedProduct != null) {
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean updateProduct(Long productId, String name, double price, int quantity, Date manufacturedDate, Date expiryDate) {
		
		
		Product updateProduct = productDao.getProduct(productId);
		if(updateProduct == getProduct(productId)) {
			updateProduct.setName(name);
			updateProduct.setPrice(price);
			updateProduct.setQuantity(quantity);
			updateProduct.setManufacturedDate(manufacturedDate);
			updateProduct.setExpiryDate(expiryDate);
			
			return true;
			}
		else
			return false;
	}

	@Override
	public boolean deleteProduct(Long productId) {
		productDao.delete(productId);
		Product deleteProduct = productDao.getProduct(productId);		
		
		if(deleteProduct == null ) {
			return true;
		}
		else
		return false;

	}
	
	@Override
	public Product getProduct(Long productId) {
		
		return productDao.getProduct(productId);
	}


	@Override
	public List<Product> getAllProduct() {
		
		return productDao.getAllProduct();
	}
	
	

}
