package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class NewsInsert {
	private Connection connection = null;
	private Statement statement = null;
	private int status;
	
	public NewsInsert(String _title, String _message) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jweb", "root", "");
		statement = connection.createStatement();
		
		status = statement.executeUpdate("INSERT INTO jweb.news(title, message, date) "
				+ "VALUES ('" + _title + "', '" + _message + "', NOW())");
	}

	public int getStatus() {
		return status;
	}
}
