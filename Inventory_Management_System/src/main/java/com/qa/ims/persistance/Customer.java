package com.qa.ims.persistance;


public class Customer {
	
	int id;
	private String fname;
	private String lname;
	private String address1; 
	private String city;
	private String email;
	
	Customer(int id, String fname, String lname, String address1, String city, String email) {
	this.id = id;
	this.fname = fname;
	this.lname = lname;
	this.address1 = address1;
	this.city = city;
	this.email = email;
	}
	
	public Customer() {
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}


	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
	
	public void placeOrder(Customer customer) {
			
		
	}

	@Override
	public String toString() {
		return "Customer [id=" + getId() + ", fname=" + getFname() + ", lname=" + getLname() + ", address1=" + getAddress1() + ", city="
				+ getCity() + ", email=" + getEmail() + "]";
	}

}