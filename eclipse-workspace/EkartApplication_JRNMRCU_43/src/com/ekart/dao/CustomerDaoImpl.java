package com.ekart.dao;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.ekart.model.Customer;
import com.ekart.model.Product;

public class CustomerDaoImpl implements ICustomerDao {
	
	private static Map<Long, Customer> customers;
	
	public CustomerDaoImpl() {
		
		if(null == customers) {
			customers = new HashMap<>();
		}
	}

	@Override
	public void addCustomer(Customer customer) { //Adding the customer details in the map
		
		customers.put(customer.getCustomerId(), customer);

	}

	@Override
	public List<Product> viewNonExpiredProducts(List<Product> product) {
		
		//Creating an Array list to store the non expired(available) products in the catalogue

		ArrayList<Product> nonExpiredProductList = new ArrayList<>();
		
		for(Product p : product) { //Iterating through the list to add products with expire date as null or after today
			Date todayDate = new Date();
			if ( p.getExpiryDate().after(todayDate) || p.getExpiryDate() == null) {
				
				nonExpiredProductList.add(p);
			}
			}
		return nonExpiredProductList;
	}


	@Override
	public Customer getCustomer(Long customerId) { //Get a customer detail using ID
		
		return customers.get(new Long(customerId));
	}
	
	@Override
	public List<Customer> getAllCustomers(){ //Get list of all registered customers
		//Create empty array list to store values from the customers map
	ArrayList<Customer> list = new ArrayList<>();
	
	Collection<Customer> customerList = customers.values();
	
	for(Customer c : customerList) {
		list.add(c);
	}
	return list;
}

}
