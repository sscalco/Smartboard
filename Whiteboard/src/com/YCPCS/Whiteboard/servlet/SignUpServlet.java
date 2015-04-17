package com.YCPCS.Whiteboard.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.YCPCS.Whiteboard.Database.DatabaseProvider;
import com.YCPCS.Whiteboard.Model.User;

public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doRequest(req, resp);
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doRequest(req, resp);
	}
	
	private void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String signup = (String) req.getParameter("signup");
		if(signup!=null && signup.equals("true")){
			System.out.println("Signing Up!");
			User user = new User();
			user.setFirstname((String) req.getParameter("firstname"));
			user.setLastname((String) req.getParameter("lastname"));
			user.setUsername((String) req.getParameter("username"));
			user.setPassword((String) req.getParameter("password"));
			user.setEmail((String) req.getParameter("email"));
			DatabaseProvider.getInstance().addUserToDatabase(user);
			resp.sendRedirect(req.getContextPath() + "/login");
		}else{
			req.getRequestDispatcher("/_view/signup.jsp").forward(req, resp);
		}
		return;
	}
}
