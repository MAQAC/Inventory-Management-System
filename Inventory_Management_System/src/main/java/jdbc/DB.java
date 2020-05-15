package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DB {
	
	public static final String USER = "root";
	public static final String PASSWORD = "root";
	public static final String DB_URL = "jdbc:mysql://localhost/gamedb?serverTimezone=UTC";
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	private static Connection conn = null;
	private static Statement stmt = null;
	
	
	static void connect() {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(DB_URL, USER, USER);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static void exUpdate(String query) {
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	static ResultSet exQuery(String query) {
		ResultSet r = null;
		try {
			r = stmt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public void close() throws SQLException {
		conn.close();
	}
	//Add Customer
	public void create(int id, String name, String address, String email, String contact, String password, String postcode, String age) throws SQLException {
		String sql = "INSERT INTO customer (`customer_ID`, `name`, `address`, `email`, `contact_details`, `password`, `postcode`, `AGE`) VALUES ('" + id + "', '" + name + "', '" + address + "', '" + email + "', '" + contact + "', '" + password + "', '" + postcode + "', '" + age + "')";
		this.stmt = conn.createStatement();
		this.stmt.execute(sql);
	}
	
	public void createCust() {
	String sql = "INSERT INTO customer (`customer_ID`, `name`, `address`, `email`, `contact_details`, `password`, `postcode`, `AGE`) " 
			+ "VALUES(?,?,?,?,?,?,?,?)";
	PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	try {
	pstmt.setInt(1,customer_ID);
	pstmt.setString(2,name);
	pstmt.setString(3,address);
	pstmt.setString(4,email);
	pstmt.setString(5,contact);
	pstmt.setString(6,password);
	pstmt.setString(7,postcode);
	pstmt.setString(8,age);
	pstmt.executeUpdate();
	int status = pstmt.executeUpdate();
	if (status > 0) {
		System.out.println("Registration has been completed");
	}
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	
	
	
	
	//Add Order
	public void create(int order_ID, int customer_ID, String date_placed) throws SQLException {
		String sql = "INSERT INTO orders (`order_ID`, `fk_customer_ID`, `date_placed`) "
				+ "VALUES ('" + order_ID + "', '" + customer_ID + "', '" + date_placed + "')";
		this.stmt = conn.createStatement();
		this.stmt.execute(sql);
	}
	
    }
	
	public void read() throws SQLException {
		this.stmt = conn.createStatement();
		String sql = "SELECT * FROM customer";
		ResultSet results = this.stmt.executeQuery(sql);
		while (results.next()) {
			System.out.println(results.getString("name") + " " + results.getString("address"));
		}
	}
	
	
	
	
	
}
