package com.ekart.controller;

import java.util.Scanner;

import com.ekart.model.Customer;
import com.ekart.model.Product;
import com.ekart.service.CustomerServiceImpl;
import com.ekart.service.ICartService;
import com.ekart.service.ICustomerService;
import com.ekart.service.IProductService;
import com.ekart.service.ProductServiceImpl;
import com.ekart.util.InputUtil;
import com.ekart.Validation.ValidationForCustomer;;

public class CustomerController {
	
	private static ICustomerService customerService;
	private static IProductService productService;
	private static ICartService cartService;
		
		public CustomerController() {
			
			if(null == customerService) {
				customerService = new CustomerServiceImpl();
			}
			
			if(null == productService) {
				productService = new ProductServiceImpl();
			}
		}
			
		public void operations() {
			
			Scanner scanner = InputUtil.getScanner();
			boolean status = true;
			while (status) {
			
			System.out.println("-----CUSTOMER OPERATIONS-----");
			System.out.println("1. Register Now!  \n 2. View Available Products  \n 3. Add Product to cart \n 4. View Cart \n 5. Exit");
			
			System.out.println("Choose option: ");
			int option = scanner.nextInt();
			
			switch(option) {
			
			case 1:  //Customer self-registration
				System.out.println("Enter your customerID: ");
				Long customerId = scanner.nextLong();
				System.out.println("Enter your name: ");
				String name = scanner.next();
				System.out.println("Enter your phone number: ");
				double phoneNumber = scanner.nextDouble();
				System.out.println("Enter your address: ");
				String address = scanner.next();
				System.out.println("Enter your emailID: ");
				String emailId = scanner.next();
				
				Customer c = new Customer(customerId, name, emailId, phoneNumber, address);
				
				c.setCustomerId(customerId);
				c.setName(name);
			    c.setEmailId(emailId);
				c.setPhone(phoneNumber);
				c.setAddress(address);
				
				if (customerService.addCustomer(c) && ValidationForCustomer.validateEmail(emailId)) {
					System.out.println("Customer " + c.getCustomerId() + " is added successfully!");
				} else {
					System.out.println("Customer " + c.getCustomerId() + " is not added! Please check email Id.");
				}
				break;
				
			case 2: //To view the available products
				Product product1 = new Product(1001L,"Toy Car", 450.00, 15);
				Product product2 = new Product(1002L, "Cup", 100.00, 30);
				Product product3 = new Product(1003L, "Hat", 150.00, 12);
				System.out.println(product1);
				System.out.println(product2);
				System.out.println(product3);
				System.out.println(customerService.viewNonExpiredProducts(productService.getAllProduct()));
				break;
			
			case 3: //Adding products to cart
				System.out.println("Enter the ID of product to add to cart");
				Long productId = scanner.nextLong();
				System.out.println("Enter your customer Id");
				customerId = scanner.nextLong();
				if(cartService.addProductsToCart(customerId, productId)){
				
					System.out.println("Product " +productId + " successfully added to cart!");
					
				}
				else
					System.out.println("Product " +productId + " not added to cart.");
				break;
			
			case 4: //View cart
				System.out.println("Enter your customer Id");
				customerId = scanner.nextLong();
				System.out.println(cartService.viewCart(customerId));
				
			case 5:
				System.out.println("Exiting customer operations..!");
				status = false;
			}
}
		}


}
