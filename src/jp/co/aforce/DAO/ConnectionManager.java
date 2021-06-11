package jp.co.aforce.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	private final static String URL = "jdbc:mysql://localhost:3306/database";
	private final static String USER = "root";
	private final static String PASSWORD = null;
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}

