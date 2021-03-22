package com.ekart.service;

import java.util.List;

import com.ekart.dao.CustomerDaoImpl;
import com.ekart.dao.ICustomerDao;
import com.ekart.model.Customer;
import com.ekart.model.Product;


public class CustomerServiceImpl implements ICustomerService {

	private static ICustomerDao customerDao;
	
	public CustomerServiceImpl() {
		
		if(null == customerDao) {
			customerDao = new CustomerDaoImpl();
		}
	}
	@Override
	public boolean addCustomer(Customer customer) {
		
		
		customerDao.addCustomer(customer);
		Customer savedCustomer = customerDao.getCustomer(customer.getCustomerId());
		
		if(savedCustomer != null) {
			return true;
		}
		else
			return false;

	}

	@Override
	public List<Product> viewNonExpiredProducts(List<Product> product) {
		
		return customerDao.viewNonExpiredProducts(product);
		

	}

	
	@Override
	public Customer getCustomer(Long customerId) {
		
		return customerDao.getCustomer(customerId);
	}
	
	@Override
	public List<Customer> getAllCustomers() {
		
		return customerDao.getAllCustomers();
}
}
