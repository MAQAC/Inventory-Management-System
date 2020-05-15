package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Appeal {

	int id;
	String name;
	String country;
	String region;
	float price;
	
	public Appeal(int id, String name, String country, String region, float price)  {
		this.id = id;
		this.name = name;
		this.country = country;
		this.region = region;
		this.price = price;
	}
	
	
	//view appeals available
	
	public Appeal queryAppeal(int id) {
		
		String query = "SELECT * FROM appeals WHERE appealID = " + id;
		int appealIDtemp = 0;
		String nameTemp = null;
		String countryTemp = null;
		String regionTemp = null;
		float priceTemp = 0;
		
		ResultSet rs = DB.exQuery(query);
		
		try {
			while(rs.next()) {
			appealIDtemp = rs.getInt("appealID");
			nameTemp = rs.getString("name");
			countryTemp = rs.getString("country");
			regionTemp = rs.getString("region");
			priceTemp = rs.getFloat("monthly_price");
			} 
		} catch (SQLException e) {
			e.printStackTrace();
			}
		return new Appeal(appealIDtemp, nameTemp, countryTemp, regionTemp, priceTemp);
		}
}


