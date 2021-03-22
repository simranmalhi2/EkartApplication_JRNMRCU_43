package com.ekart.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.ekart.exception.InvalidProductIdException;
import com.ekart.model.Customer;
import com.ekart.model.Product;
import com.ekart.service.CustomerServiceImpl;
import com.ekart.service.ICustomerService;
import com.ekart.service.IProductService;
import com.ekart.service.ProductServiceImpl;

import com.ekart.util.*;

public class AdminController {
	
	//defining variables from service layer
	private static IProductService productService;
	private static ICustomerService customerService;
	
	public AdminController() {
		
		if(null == productService) {
			productService = new ProductServiceImpl();
		}
		
		if(null ==  customerService) {
			customerService = new CustomerServiceImpl();
		}
	}
		
	
	public void operations() throws ParseException, InvalidProductIdException {
		
		Scanner scanner = InputUtil.getScanner();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		boolean status = true;
		
		while (status) {
			
		
		System.out.println("-----ADMIN OPERATIONS-----");
		System.out.println("1. Operations on Products \n 2.Operations on Customers \n 3. Exit");
		
		System.out.println("Choose option: ");
		int option = scanner.nextInt();
		
		switch(option) {
		case 1: //Administrator Operations Main
			System.out.println("----Operations on Products----");
			System.out.println("1. Add Product \n 2.Update Product \n 3.View Product \n 4.View All Products \n 5. Remove Product \n 6.Exit");
		    System.out.println("Enter the choice:");
		    int choiceProduct = scanner.nextInt();
		    

		   switch (choiceProduct) {

		    case 1: //Adding product details
		   
			System.out.println("Enter the product ID, Name, Price and Quantity, manufactured date and expired date:");
			Long id = scanner.nextLong();
			String name = scanner.next();
			double price = scanner.nextDouble();
			int quantity = scanner.nextInt();
			String mDate = scanner.next();
			String eDate = scanner.next();
			
			
			
			Date manufacturedDate = format.parse(mDate);
			Date expiryDate = format.parse(eDate);
			
			Product p = new Product(id, name, price, quantity, manufacturedDate, expiryDate );
			p.setProductId(id);
			p.setName(name);
			p.setPrice(price);
			p.setManufacturedDate(manufacturedDate);
			p.setExpiryDate(expiryDate);
			
			if (productService.addProduct(p)) {
				System.out.println("Product " + p.getProductId() + " is added successfully!");
			} else {
				System.out.println("Product " + p + "is not added! Please try again!");
			}
		    
			break;

		case 2: //Updating product details
			System.out.println("Enter the product Id whose details are to be updated: ");
			id = scanner.nextLong();
			
			System.out.println("Enter the Name, Price and Quantity to be updated");
			name = scanner.next();
			price = scanner.nextDouble();
			quantity = scanner.nextInt();
			mDate = scanner.next();
		    eDate = scanner.next();
			manufacturedDate = format.parse(mDate);
			expiryDate = format.parse(eDate);

			p = new Product(id, name, price, quantity,manufacturedDate, expiryDate );
			p.setProductId(id);
			p.setName(name);
			p.setPrice(price);
			p.setQuantity(quantity);
			p.setManufacturedDate(manufacturedDate);
			p.setExpiryDate(expiryDate);
			
			if (productService.updateProduct(id, name, price, quantity, manufacturedDate, expiryDate)) {
				System.out.println("Product " + p.getProductId() + " is updated successfully!");
			} else {
				System.out.println("Product " + p + "is not updated! Please try again!");
			}
			break;

		case 3: //view the product details
			System.out.println("Enter the ID of product to be viewed: ");
			id = scanner.nextLong();
			Product product = productService.getProduct(id);
			System.out.println(product);
			break;
			
		case 4: //Displaying list of products
			List<Product> allProducts = productService.getAllProduct();

			for (Product productDetail : allProducts) {
				System.out.println(productDetail);
			}
			break;
			
		case 5: // Delete a product from the list
			System.out.println("Enter the ID of product to be removed: ");
			id = scanner.nextLong();
			if(productService.deleteProduct(id)) {
				System.out.println("Product " + id + " deleted successfully!");
			}
			
			break;

		case 6:
			System.out.println("Exiting operations on products!");
			status = false;

		}

		case 2:
			System.out.println("----Operations on Customers----");
			System.out.println("1. View Customer \n 2.Purchased Products \n 3.Order Details \n 4.Exit");
		    System.out.println("Enter the choice:");
		    int choiceCustomer = scanner.nextInt();
		    
		    switch (choiceCustomer) {
		    
		    case 1: //To view customer details
		    	
		    	System.out.println("Enter the ID of customer to be viewed: ");
				Long id = scanner.nextLong();
				Customer customer = customerService.getCustomer(id);
				System.out.println(customer);
				break;
				
		    case 2:
		    	break;
		    	
		    case 3:
		    	break;
		    	
		    case 4:
		    	System.out.println("Exiting operations on customers!");
				status = false;
		    	break;
		    	
		    }
		case 3:
			System.out.println("Exiting admin operations..!");
			status=false;
			
	}

}	
}
}

