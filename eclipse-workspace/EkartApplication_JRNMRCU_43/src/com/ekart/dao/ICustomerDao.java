package com.ekart.dao;

import java.util.List;


import com.ekart.model.Customer;
import com.ekart.model.Product;


public interface ICustomerDao {
	
	void addCustomer(Customer customer);

	List<Product> viewNonExpiredProducts(List<Product> products);
	
	Customer getCustomer(Long customerId);

	List<Customer> getAllCustomers();

}
