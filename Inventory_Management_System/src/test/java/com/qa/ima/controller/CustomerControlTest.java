package com.qa.ima.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.qa.ims.persistance.Customer;
import com.qa.ims.persistance.DB;

public class CustomerControlTest {

	@Mock
	Statement mockstatement;
	
	@Mock
	Connection connection;
	
	@Mock
	Customer cust = mock(Customer.class);
		
	@Mock
	CustomerControl customerc = mock(CustomerControl.class);
	
	
		
	@InjectMocks
	DB database;
	
	@Before
	public void connect() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void createTest() throws SQLException {
		when(connection.createStatement()).thenReturn(mockstatement);
		
		
		String fname = "John";
		cust.setFname("John");
		String lname = "Hill";
		cust.setLname("Hill");
		String address = "123 Park Avenue";
		cust.setAddress1("123 Park Avenue");
		String city = "Leicester";
		cust.setCity("Leiceser");
		String email = "jhill@qa.com";
		cust.setEmail("jhill@qa.com");
		
		
		customerc.insertCustomer(cust);
		
		String queryTest = "INSERT INTO customer (`first_name`, `last_name`, `address1`, `city`, `email`)" + " VALUES ('" +  fname + "','" + lname + "','" + address 
		+ "','" + city + "','" + email +"')";
		
		verify(mockstatement).executeUpdate(queryTest);
	}
	
	@Test
	public void updateCustTest() throws SQLException {
		when(connection.createStatement()).thenReturn(mockstatement);
		
		int id = 2;
		String fname = "John";
		cust.setFname(fname);
		String lname = "Hill";
		cust.setLname(lname);
		String address = "123 Park Avenue";
		cust.setAddress1(address);
		String city = "Leicester";
		cust.setCity(city);
		String email = "jhill@qa.com";
		cust.setEmail(email);
		
		customerc.updateCustomer(cust, id);
		
		String queryTest = "UPDATE customer SET `first_name` = '" + fname + "', last_name = '" + lname + "', address1 = '" + address 
		+  "', city = '" + city + "', email = '" + email + "' WHERE customerID = " + id;
		
		verify(mockstatement).executeUpdate(queryTest);

		
	}
}
