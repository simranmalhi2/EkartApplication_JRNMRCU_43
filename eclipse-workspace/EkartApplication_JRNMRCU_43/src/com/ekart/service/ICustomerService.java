package com.ekart.service;

import java.util.List;

import com.ekart.model.Customer;
import com.ekart.model.Product;

public interface ICustomerService {
		
		boolean addCustomer(Customer customer);

		List<Product> viewNonExpiredProducts(List<Product> product);

		Customer getCustomer(Long customerId);

		List<Customer> getAllCustomers();
		
	}
