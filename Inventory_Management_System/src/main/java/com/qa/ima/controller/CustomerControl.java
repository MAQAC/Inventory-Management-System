package com.qa.ima.controller;


import java.sql.ResultSet;
import java.sql.SQLException;

import com.qa.ims.persistance.Customer;
import com.qa.ims.persistance.DB;

public class CustomerControl {
	Customer b;
	CustomerControl(Customer b) {
		
	}
	CustomerControl() {
	
	}
	
	//insert a customer
	public void insertCustomer(Customer a) {
		String query = "INSERT INTO customer (`first_name`, `last_name`, `address1`, `city`, `email`)" + " VALUES ('" +  a.getFname() + "','" + a.getLname() + "','" + a.getAddress1() 
				+ "','" + a.getCity() + "','" + a.getEmail() +"')";
	DB.exUpdate(query);
	
	}
	
	//View Customer
	
	public void showCustomer(Customer a, int id) {
		
		String query = "SELECT * FROM customer WHERE customerID = " + id;
		
		ResultSet rs = DB.exQuery(query);
		
		try {
			while(rs.next()) {
				
//				int customerIDtemp = 0;
				String fnameTemp = null;
				String lnameTemp = null;
				String address1Temp = null;
				String cityTemp = null;
				String emailTemp = null;
				
//			customerIDtemp = rs.getInt("appealID");
//			a.setId(customerIDtemp);
			fnameTemp = rs.getString("first_name");
			a.setFname(fnameTemp);
			lnameTemp = rs.getString("last_name");
			a.setLname(lnameTemp);
			address1Temp = rs.getString("address1");
			a.setAddress1(address1Temp);
			cityTemp = rs.getString("city");
			a.setCity(cityTemp);
			emailTemp = rs.getString("email");
			a.setEmail(emailTemp);
			System.out.println(a);
			
			} 
		} catch (SQLException e) {
			e.printStackTrace();
			}	
		}
	
	public void showID(Customer a) {
		String query = "SELECT customerID FROM customer";
		ResultSet rs = DB.exQuery(query);
		int id = 0;
			try {
				while (rs.next())
					try {
					id = rs.getInt("customerID");
					} catch (SQLException e) {
						e.printStackTrace();
					}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("========================================================");
			System.out.println("\n");
			System.out.println("Your customer ID is: " + id);
	}
	
	//Update Customer
		public void updateCustomer(Customer a, int id) throws SQLException {
			String query = "UPDATE customer SET `first_name` = '" + a.getFname() + "', last_name = '" + a.getLname() + "', address1 = '" + a.getAddress1() 
					+  "' city = '" + a.getCity() + "' email = '" + a.getEmail() + "' WHERE customer_ID = " + id;
			DB.exUpdate(query);
			}
		
		//Delete Customer

		public void deleteCustomer(int id) {
			String query = "DELETE FROM customer WHERE id = " + id;
			DB.exUpdate(query);	
		}
						
		public void readCustomer(int id) {
			String query = "SELECT * FROM customer WHERE customerID = " + id;
			ResultSet rs = DB.exQuery(query);
			try {
				while (rs.next()) {
					String name = null;
					try {
						name = rs.getString("first_name") + " " + rs.getString("last_name") + " " + rs.getString("address1") + " " + rs.getString("city") +
								" " + rs.getString("email");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(name);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}



	
	
	
}



