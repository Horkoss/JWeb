package models;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class NewsInfo {
	private String title;
	private String message;
	private String date;
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet result = null;
	
	
	public NewsInfo() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/jweb", "root", "");
		statement = (Statement) connection.createStatement();
		
		result = statement.executeQuery("SELECT * FROM news");
		
		if (result.next()) {
			this.title = result.getString("title");
			this.message = result.getString("message");
			this.date = result.getString("date");
		}
		result.close();
		statement.close();
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
