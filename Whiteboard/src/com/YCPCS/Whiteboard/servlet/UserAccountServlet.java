package com.YCPCS.Whiteboard.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.YCPCS.Whiteboard.Model.User;

public class UserAccountServlet extends HttpServlet{
		private static final long serialVersionUID = 1L;
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doRequest(req, resp);
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doRequest(req, resp);
		}
		
		protected void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			User user = (User) req.getSession().getAttribute("user");
			if (user == null) {
				// User is not logged in, redirect to login page
				resp.sendRedirect(req.getContextPath() + "/login");
				return;
			}
			else{
				req.setAttribute("username", user.getFirstname());
				user.setFirstname((String) req.getParameter("firstname"));
				user.setLastname((String) req.getParameter("lastname"));
				user.setUsername((String) req.getParameter("username"));
				user.setPassword((String) req.getParameter("password"));
				user.setEmail((String) req.getParameter("email"));
			}
			req.getRequestDispatcher("/_view/account.jsp").forward(req, resp);
			
			
		}
}
