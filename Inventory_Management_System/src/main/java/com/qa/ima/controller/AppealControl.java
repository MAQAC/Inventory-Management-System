package com.qa.ima.controller;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qa.ims.persistance.Appeal;
import com.qa.ims.persistance.DB;

public class AppealControl {
	
	
	public void insertAppeal(Appeal a) {
		String query = "INSERT INTO appeals (`name`, `region`, `monthly_price`)" + " VALUES ('" +  a.getName() + "','" + a.getRegion() + "'," +  a.getPrice() + ")";
		DB.exUpdate(query);
		
	}
	
	public void queryAppeal(Appeal a) {
		
		//String query = "SELECT * FROM appeals WHERE appealID = " + id;
		String query = "SELECT * FROM appeals"; 
		
		
		ResultSet rs = DB.exQuery(query);
		
		int appealIDtemp = 0;
		String nameTemp = null;
		String regionTemp = null;
		BigDecimal priceTemp = null;
		
		try {
			while(rs.next()) {
			appealIDtemp = rs.getInt("appealID");
			a.setId(appealIDtemp);
			nameTemp = rs.getString("name");
			a.setName(nameTemp);
			regionTemp = rs.getString("region");
			a.setRegion(regionTemp);
			priceTemp = rs.getBigDecimal("monthly_price");
			a.setPrice(priceTemp);
			System.out.println(a);
			} 
		} catch (SQLException e) {
			e.printStackTrace();
			}
		}
	
	//return price 
	public BigDecimal appPrice(Appeal a, int id) {
		String query = "SELECT monthly_price FROM appeals WHERE appealID = " + id;
		ResultSet rs = DB.exQuery(query);
		
		BigDecimal priceret = null;
		try {
			while(rs.next()) {
				 priceret = rs.getBigDecimal("monthly_price");
				 a.setPrice(priceret);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(priceret);
		return priceret;
	}

}
