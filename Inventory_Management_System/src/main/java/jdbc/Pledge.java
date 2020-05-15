package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
public class Pledge {

	int id;
	int custid;
	Date pledgedate;
	
	public Pledge(int id, int custid, Date pledgedate) {
		this.id = id;
		this.custid = custid;
		this.pledgedate = pledgedate;
	}
	
	//Create Pledge
	public void insertPledge() {
		String query = "INSERT INTO pledges VALUES ('" + id + ",'" + custid + ",'" + pledgedate + ")";
		DB.exUpdate(query);
	}
	
	//Find Pledge
public Pledge queryPledge(int id) {
		
		String query = "SELECT * FROM pledges WHERE pledgeID = " + id;
		int pledgeIDtemp = 0;
		int customerIDTemp = 0;
		Date pledgeDateTemp = null;
		
		
		ResultSet rs = DB.exQuery(query);
		
		try {
			while(rs.next()) {
			pledgeIDtemp = rs.getInt("pledgeID");
			customerIDTemp = rs.getInt("customerID");
			pledgeDateTemp = rs.getDate("date_placed");
			
			} 
		} catch (SQLException e) {
			e.printStackTrace();
			}
		return new Pledge(pledgeIDtemp, customerIDTemp, pledgeDateTemp);
		}
	
}
