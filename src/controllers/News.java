package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.NewsInsert;
import models.UserInfo;

/**
 * Servlet implementation class News
 */
@WebServlet("/News")
public class News extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public News() {
        super();
        // TODO Auto-generated constructor stub
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
			UserInfo user = (models.UserInfo) request.getSession().getAttribute("user");
			request.setAttribute("user", user);
			rd = request.getRequestDispatcher("/form.jsp");
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
		} else {
			request.setAttribute("user", request.getSession().getAttribute("user"));
			
			try {
				NewsInsert news = new NewsInsert(request.getParameter("title"), request.getParameter("message"));
				if (news.getStatus() == 0) {
					request.setAttribute("message", "An error as occured while publishing the article");
				} else {
					request.setAttribute("message", "Done");
				}
			rd = request.getRequestDispatcher("/form.jsp");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			rd.forward(request, response);
		}
	}
}
