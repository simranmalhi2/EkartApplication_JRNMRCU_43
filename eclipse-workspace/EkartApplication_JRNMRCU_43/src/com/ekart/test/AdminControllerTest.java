package com.ekart.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ekart.model.Product;
class AdminControllerTest {
	
	@BeforeEach
	void setup() throws Exception{
		
	}
	
	@AfterEach
	void tearDown() throws Exception{
		
	}


	@Test
	void testOperationsPositiveProductId() {
		Product product = new Product();
		product.setProductId(200L);
		Long id = product.getProductId();
		assertTrue(id >= 1001L && id < 10000);
		System.out.println("Test case passed");
		
	}
	
	@Test
	void testOperationsNegativeProductId() {
		Product product = new Product();
		product.setProductId(-1L);
		Long id = product.getProductId();
		assertTrue(id < 0);
		System.out.println("Test case fails: negative value");
		
	}

	@Test
	void testOperationsNullProductId() {
		Product product = new Product();
		product.setProductId(null);
		Long id = product.getProductId();
		assertTrue(id == null);
		System.out.println("Test case fails: null value");
		
	}
}
