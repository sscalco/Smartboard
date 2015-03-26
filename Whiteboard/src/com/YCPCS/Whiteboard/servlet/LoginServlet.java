package com.YCPCS.Whiteboard.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.YCPCS.Whiteboard.Controller.LoginController;
import com.YCPCS.Whiteboard.Model.User;

public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doRequest(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doRequest(req, resp);
	}
	
	private void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Get parameters
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		// Check whether parameters are valid
		if (username == "" || password == "") {
			req.setAttribute("errorMessage", "You must enter both a username and a password");
		} else {
			LoginController controller = new LoginController();
			
			User user = (User) controller.findUser(username, password);
			if (user != null) {
				// Successful login: add user to session
				req.getSession().setAttribute("user", user);
				resp.sendRedirect(req.getContextPath() + "/hub");
				return;
			}
			
			req.setAttribute("errorMessage", "No such username/password");
		}
		
		req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
	}
}
