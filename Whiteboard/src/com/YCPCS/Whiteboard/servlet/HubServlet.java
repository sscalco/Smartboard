package com.YCPCS.Whiteboard.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.YCPCS.Whiteboard.Model.User;

public class HubServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doRequest(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doRequest(req, resp);
	}
	
	private void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String doLogout = (String)req.getParameter("logout");
		String doAccount = (String)req.getParameter("account");
		if(doLogout!=null && doLogout.equals("true")){
			resp.encodeRedirectURL("/login");
		}
		else if(doAccount != null && doAccount.equals("true")){
			resp.encodeRedirectURL("/account");
		}
		else{
			User user = (User) req.getSession().getAttribute("user");
			if (user == null) {
				// User is not logged in, redirect to login page
				// FIXME: this would be better to do using a filter
				resp.sendRedirect(req.getContextPath() + "/login");
				return;
			}else{
				req.setAttribute("username", user.getFirstname());
			}
		req.getRequestDispatcher("/_view/hub.jsp").forward(req, resp);
		}
	}
}
