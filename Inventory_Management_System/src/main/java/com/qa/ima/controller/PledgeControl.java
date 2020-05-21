package com.qa.ima.controller;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qa.ims.persistance.DB;
import com.qa.ims.persistance.Pledge;

public class PledgeControl {

	
	//Create Pledge
		public void insertPledge(int custid, String date, BigDecimal price) {
			String query = "INSERT INTO pledges (`customerID`, `date_placed`, `price`)" + "VALUES (" + custid + ",'" + date + "'," + price + ")";
			DB.exUpdate(query);
		}
		
		//Find Pledge
		public void queryPledge(Pledge p, int id) {
				
				String query = "SELECT * FROM pledges WHERE customerID = " + id;
				int pledgeIDtemp = 0;
				int customerIDTemp = 0;
				java.sql.Date pledgeDateTemp = null;
				BigDecimal priceTemp = null;
				
				ResultSet rs = DB.exQuery(query);
				
				try {
					while(rs.next()) {
					pledgeIDtemp = rs.getInt("pledgeID");
					p.setId(pledgeIDtemp);
					customerIDTemp = rs.getInt("customerID");
					p.setCustid(customerIDTemp);
					pledgeDateTemp = rs.getDate("date_placed");
					p.setPledgedate(pledgeDateTemp);
					priceTemp = rs.getBigDecimal("price");
					p.setPrice(priceTemp);
					
					} 
				} catch (SQLException e) {
					e.printStackTrace();
					}
				System.out.println(p);
				}
		
		//recv pledge id
		public int pledgeId() {
			String query = "SELECT pledgeID FROM pledges";
			ResultSet rs = DB.exQuery(query);
			int pledgeId = 0;
			
			try {
				while(rs.next()) {
					pledgeId = rs.getInt("pledgeID");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println(pledgeId);
			return pledgeId;
			}
}
