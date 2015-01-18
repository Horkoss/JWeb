package models;

import java.sql.*;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class UserInfo {
	private String username;
	private String first_name;
	private String last_name;
	private String email;
	private int id;
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet result = null;
	private boolean super_user = false;
	private boolean sub_newsletter = false;
	private String date_inscription;
	private boolean exist = false;
	
	public UserInfo(String _email, String _password) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/jweb", "root", "");
		statement = (Statement) connection.createStatement();
		
		result = statement.executeQuery("SELECT * FROM users WHERE email='"+ _email +"' AND password='" + _password + "'");

		if (result.next()) {
			this.exist = true;
			this.id = result.getInt("id");
			this.first_name = result.getString("first_name");
			this.last_name = result.getString("last_name");
			this.username = result.getString("username");
			this.email = result.getString("email");
			this.date_inscription = result.getString("date_inscription");
			if (result.getInt("super_user") == 1)
				this.super_user = true;
			if (result.getInt("newsletter") == 1)
				this.sub_newsletter = true;
		} else 	{
			exist = false;
		}
		result.close();
		statement.close();
	}
	
	
	
	public boolean ifExist() {
		return (this.exist);
	}

	public boolean isSuper_user() {
		return super_user;
	}

	public boolean isSub_newsletter() {
		return sub_newsletter;
	}

	public void setSub_newsletter(boolean sub_newsletter) {
		this.sub_newsletter = sub_newsletter;
	}

	public String getDate_inscription() {
		return date_inscription;
	}

	public void setDate_inscription(String date_inscription) {
		this.date_inscription = date_inscription;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
