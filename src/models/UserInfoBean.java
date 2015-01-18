package models;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@ManagedBean(name="userinfo")
@SessionScoped
public class UserInfoBean implements Serializable {
	@Resource(name="jdbc/jweb")
	private DataSource ds;
	List<UserInfo> list = new ArrayList<UserInfo>();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ResultSet result = null;
	
	public UserInfoBean() throws ClassNotFoundException, SQLException {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/jweb");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public List<UserInfo> getUserList() throws SQLException {
		Connection connection = ds.getConnection();
		
		PreparedStatement ps 
		= connection.prepareStatement(
		   "SELECT * FROM users WHERE super_user=0"); 
		
		result = ps.executeQuery();
		
		while (result.next()) {
			UserInfo user;
			try {
				user = new UserInfo(result.getString("email"), result.getString("password"));
				list.add(user);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//user.setId(result.getInt("id"));
			//user.setFirst_name(result.getString("first_name"));
			//user.setLast_name(result.getString("last_name"));
			//user.setEmail(result.getString("email"));
			//user.setUsername(result.getString("username"));
			//list.add(user);
		}
		result.close();
		connection.close();
		return (list);
	}
	
	public int delete(String id) throws SQLException {
		Connection connection = ds.getConnection();
		
		PreparedStatement ps 
		= connection.prepareStatement(
		   "DELETE FROM users WHERE id='" + id + "'" );
		
		int status = ps.executeUpdate();
		connection.close();
		return (status);
	}

	public int ban(String id) throws SQLException {
Connection connection = ds.getConnection();
		
		PreparedStatement ps 
		= connection.prepareStatement(
		   "UPDATE users SET ban=1 WHERE id='" + id + "'" );
		
		int status = ps.executeUpdate();
		connection.close();
		return (status);
	}
}
