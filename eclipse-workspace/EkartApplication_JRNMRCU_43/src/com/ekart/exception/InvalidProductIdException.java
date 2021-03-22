package com.ekart.exception;

public class InvalidProductIdException extends Exception{
	
	
	private static final long serialVersionUID = 1L;

	public InvalidProductIdException(String str) {
		System.out.println(str);
	}

	
}
