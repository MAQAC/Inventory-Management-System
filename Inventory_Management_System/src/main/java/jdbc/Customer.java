package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer {
	
	int id;
	String fname;
	String lname;
	String address1; 
	String address2; 
	String city;
	String password; 
	String postcode; 
	String age;
	
	Customer(int id, String fname, String lname, String address1, String address2, String city, String postcode) {
	this.id = id;
	this.fname = fname;
	this.lname = lname;
	this.address1 = address1;
	this.address2 = address2;
	this.city = city;
	this.postcode = postcode;
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

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	//insert a customer
	public void insertCustomer() {
		String query = "INSERT INTO customer VALUES (" + this.id + ",'" + this.fname + ",'" + this.lname + ",'" + this.address1 + ",'" + this.address2
				+ ",'" + this.city + ",'" + this.postcode +")";
	DB.exUpdate(query);
	}
	
	//Update Customer
	public void updateCustomer() throws SQLException {
		String query = "UPDATE customer SET `first_name` = '" + getFname() + "', last_name = '" + getLname() + "', address1 = '" + getAddress1() 
				+ "' address2 = '" + getAddress2() + "' city = '" + getCity() + "' postcode = '" + getPostcode() + "' WHERE customer_ID = " + id;
		DB.exUpdate(query);
		}
	
	
	//View Customer
	
public Customer showCustomer(int id) {
		
		String query = "SELECT * FROM customer WHERE custoemrID = " + id;
		int customerIDtemp = 0;
		String fnameTemp = null;
		String lnameTemp = null;
		String address1Temp = null;
		String address2Temp = null;
		String cityTemp = null;
		String postcodeTemp = null;
		
		ResultSet rs = DB.exQuery(query);
		
		try {
			while(rs.next()) {
			customerIDtemp = rs.getInt("appealID");
			fnameTemp = rs.getString("first_name");
			lnameTemp = rs.getString("last_name");
			address1Temp = rs.getString("address1");
			address2Temp = rs.getString("address2");
			cityTemp = rs.getString("city");
			postcodeTemp = rs.getString("postcode");
			
			} 
		} catch (SQLException e) {
			e.printStackTrace();
			}
		return new Customer(customerIDtemp, fnameTemp, lnameTemp, address1Temp, address2Temp, cityTemp, postcodeTemp);
		}

	//Delete Customer

public void deleteCustomer(int id) {
	String query = "DELETE FROM customer WHERE id = " + id;
	DB.exUpdate(query);	
}



	
	
	
	
	
	
	
	
	
	
}

