package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Inscription {
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet result = null;
	public Inscription() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jweb", "root", "");
		statement = connection.createStatement();
	}
	
	public String check(String _email) throws SQLException {
		String error = null;
		result = statement.executeQuery("SELECT id, email FROM users WHERE email='" + _email + "'");
		if ((result.next())) {
			error += "E-mail already used<br/>";
		}
		return error;
	}
	
	public boolean saveUser(String _firstName, String _lastName, String _username, String _email, String _password) throws SQLException {
		int status;
		status = statement.executeUpdate("INSERT INTO jweb.users(first_name, last_name, username, email, password, date_inscription) "
				+ "VALUES ('" + _firstName + "', '" + _lastName + "', '" + _username + "', '" + _email + "', '" + _password + "', NOW())");
		if (status == 0)
			return false;
		return true;
	}
}
