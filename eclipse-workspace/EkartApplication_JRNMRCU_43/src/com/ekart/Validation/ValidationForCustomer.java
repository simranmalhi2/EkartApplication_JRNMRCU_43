package com.ekart.Validation;

import java.util.regex.Pattern;

public class ValidationForCustomer {

	public static boolean validateEmail(String emailId) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
	                            "[a-zA-Z0-9_+&*-]+)*@" + 
	                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
	                            "A-Z]{2,7}$"; 
	        
	        Pattern pat = Pattern.compile(emailRegex); 
	        if (emailId == null) 
	            return false; 
	        return pat.matcher(emailId).matches();
	}
}
