package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.UserInfo;
import models.UserInfoBean;

import java.sql.*;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		RequestDispatcher rd = null;
		UserInfo user = null;
		UserInfoBean usersbean = null;
		
		try {
			user = new UserInfo(email, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (user.ifExist() == false) {
			request.setAttribute("error_message", "Identifiant et/ou mot de passe incorrect(s)");
			rd = request.getRequestDispatcher("/index.jsp");
		} else {
			request.setAttribute("user", user);
			request.getSession().setAttribute("user", user);
			if (user.isSuper_user() == true) {
				try {
					usersbean = new UserInfoBean();
					request.setAttribute("userBean", usersbean);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				rd = request.getRequestDispatcher("/table.jsp");
			}
			else
				rd = request.getRequestDispatcher("/index.jsp");
		}
		rd.forward(request, response);
	}
}
