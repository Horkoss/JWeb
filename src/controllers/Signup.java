package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Inscription;
import models.UserInfo;

/**
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String email = request.getParameter("email");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		RequestDispatcher rd = null;
		Inscription new_user = null;
		UserInfo user = null;
		String error;

		try {
			new_user = new Inscription();
		} catch (ClassNotFoundException | SQLException e1) {
		e1.printStackTrace();
		}
	
	
		try {
			if ((error = new_user.check(email)) != null) {
				request.setAttribute("error_message", error);
				rd = request.getRequestDispatcher("/login.jsp");		
			} else if (new_user.saveUser(first_name, last_name, username, email, password) == false) {
				request.setAttribute("error_message", "Une erreur est survenue lors de l'inscription");
				rd = request.getRequestDispatcher("/login.jsp");
			} else {
				user = new UserInfo(email, password);
				request.setAttribute("user", user);
				request.getSession().setAttribute("user", user);
				rd = request.getRequestDispatcher("/index.jsp");
			}
			rd.forward(request, response);
		} catch (SQLException e) {
		e.printStackTrace();
		} catch (ClassNotFoundException e) {
		e.printStackTrace();
		}
	}
}
