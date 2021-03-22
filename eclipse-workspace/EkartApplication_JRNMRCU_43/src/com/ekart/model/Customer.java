package com.ekart.model;

public class Customer {

	private Long customerId;
	private String name;
	private String emailId;
	private double phone;
	private String address;
	
	public Customer() {
	}
	
	
	public Customer(Long customerId, String name, String emailId, double phone, String address) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.emailId = emailId;
		this.phone = phone;
		this.address = address;
	}
	
	public Customer(Long customerId) {
			super();
			this.customerId = customerId;
		}


	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public double getPhone() {
		return phone;
	}

	public void setPhone(double phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", emailId=" + emailId + ", phone=" + phone
				+ ", address=" + address + "]";
	}
	
	
	
	

}
