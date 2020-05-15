package jdbc;

import java.sql.SQLException;

public class Runner {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		DB db = new DB();
		
		db.updateCustomer("Tucker", "The Other House", 3);
		db.read();
		
	}
}