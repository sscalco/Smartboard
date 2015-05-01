package com.YCPCS.Whiteboard.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.YCPCS.Whiteboard.Controller.LectureController;
import com.YCPCS.Whiteboard.Model.Lecture;
import com.YCPCS.Whiteboard.Model.User;

public class GradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doRequest(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doRequest(req, resp);
	}

	protected void doRequest(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HERE");
		String doLogout = (String) req.getParameter("logout");
		String doHelp = (String) req.getParameter("help");
		String doAccount = (String) req.getParameter("account");

		User user = (User) req.getSession().getAttribute("user");
		if (user == null) {
			// User is not logged in, redirect to login page
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		} 
		if (doHelp != null && doHelp.equals("true")) {
			//System.out.println("Help is true: " + doHelp);
			resp.sendRedirect(req.getContextPath() + "/Help");
			return;
		} else if (doAccount != null && doAccount.equals("true")) {
			//System.out.println("Account Page is true: " + doAccount);
			resp.sendRedirect(req.getContextPath() + "/UserAccount");
			return;
		} else if (doLogout != null && doLogout.equals("true")) {
			//System.out.println("DOING LOGOUT");
			req.setAttribute("username", null);
			resp.sendRedirect(req.getContextPath() + "/login");
		}
		else{
//			req.setAttribute("grade", user.getLectures().get(0).getGrade());			
			req.setAttribute("username", user.getFirstname());
		}
		req.getRequestDispatcher("/_view/Grades.jsp").forward(req, resp);		
	}
	
}
