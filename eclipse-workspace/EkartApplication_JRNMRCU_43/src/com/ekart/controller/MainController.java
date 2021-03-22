package com.ekart.controller;
import java.text.ParseException;
import java.util.Scanner;

import com.ekart.exception.InvalidProductIdException;
import com.ekart.util.*;


public class MainController {

	public static void main(String[] args) throws ParseException, InvalidProductIdException {

		runApplication();

	}

	private static void runApplication() throws ParseException, InvalidProductIdException {
		Scanner scanner = InputUtil.getScanner();
		AdminController adminController = new AdminController();
		CustomerController customerController = new CustomerController();

		Boolean action = true;

		while (action) {

			// Displays the main page
			System.out.println("----WELCOME TO E-KART----" );
			System.out.println("Enter your choice: ");
			System.out.println("1.Admin Operations \n 2.Customer operations \n 3.Exit");
			int choice = scanner.nextInt();
		
				switch (choice) {
				case 1:
					
					adminController.operations();
					
					break;
				case 2:
					customerController.operations();
					break;
					

				case 3:
					System.out.println("-----------EXIT------------");
					
					action = false;
					break;
				default:
				}
			} 

		}

	}

