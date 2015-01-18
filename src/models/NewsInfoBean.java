package models;

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

@ManagedBean(name="newsinfo")
@SessionScoped
public class NewsInfoBean {
	@Resource(name="jdbc/jweb")
	private DataSource ds;
	List<NewsInfo> list = new ArrayList<NewsInfo>();
	public NewsInfoBean() throws ClassNotFoundException, SQLException {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/jweb");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public List<NewsInfo> getNewsList() throws SQLException {
		Connection connection = ds.getConnection();
		
		PreparedStatement ps 
		= connection.prepareStatement(
		   "SELECT * FROM news"); 
		
		ResultSet result = ps.executeQuery();
		
		while (result.next()) {
		
			NewsInfo news;
			try {
				news = new NewsInfo();
				news.setTitle(result.getString("title"));
				news.setMessage(result.getString("message"));
				news.setDate(result.getString("date"));
				list.add(news);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}	
		}
		result.close();
		connection.close();
		return (list);
	}
}
