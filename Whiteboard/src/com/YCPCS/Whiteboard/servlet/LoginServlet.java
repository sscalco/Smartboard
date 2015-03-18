package com.YCPCS.Whiteboard.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		super.doPost(req, resp);
	}
	
	private void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Get parameters
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		// Check whether parameters are valid
		if (username == null || password == null) {
			
			return;
		}
		
		//TODO: Use a controller to process the request
		
		//TODO: Send back a response
		//resp.setContentType("text/plain");
		//resp.getWriter().println(result.toString());
	}
}
