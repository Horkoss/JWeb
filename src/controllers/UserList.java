package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.UserInfo;
import models.UserInfoBean;

/**
 * Servlet implementation class UserList
 */
@WebServlet("/UserList")
public class UserList extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    UserInfoBean UsersBean = null;
    List<UserInfo> list = null;
    ServletRequest session = null;

    
    /**
     *     
 * @see HttpServlet#HttpServlet()
     */
    public UserList() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		
		if (request.getSession().getAttribute("user") == null) {
			request.setAttribute("error_message", "Accès interdit");
			rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		} else {
		
		try {
			UserInfoBean UsersBean = new UserInfoBean();
			
			if (request.getAttribute("userBean") != null)
				request.removeAttribute("userBean");
			request.setAttribute("userBean", UsersBean);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		rd = request.getRequestDispatcher("/table.jsp");
		rd.forward(request, response);
		}
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		
		if (request.getSession().getAttribute("user") == null) {
			request.setAttribute("error_message", "Accès interdit");
			rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		} else  {
		
		try {
			UserInfoBean UsersBean = new UserInfoBean();
			
			if (request.getAttribute("userBean") != null)
				request.removeAttribute("userBean");
			request.setAttribute("userBean", UsersBean);
			if (request.getParameter("delete_value") != null)
				UsersBean.delete(request.getParameter("delete_value"));
			else if (request.getParameter("ban_value") != null)
				UsersBean.ban(request.getParameter("ban_value"));
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		rd = request.getRequestDispatcher("/table.jsp");
		rd.forward(request, response);
		}
	}	
}
