package com.YCPCS.Whiteboard.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.YCPCS.Whiteboard.Model.User;

public class HubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doRequest(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doRequest(req, resp);
	}

	private void doRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String doLogout = (String) req.getParameter("logout");
		String doHelp = (String) req.getParameter("help");
		String doAccount = (String) req.getParameter("account");
		String doSchedule = (String) req.getParameter("schedule");
		String doCalendar = (String) req.getParameter("calendar");
		String doGrades = (String) req.getParameter("grades");
		String doAssignments = (String) req.getParameter("assignments");
		String doForums = (String) req.getParameter("forums");

		//System.out.println(doLogout + " " + doHelp + " " + doAccount);

		User user = (User) req.getSession().getAttribute("user");
		if (user == null) {
			// User is not logged in, redirect to login page
			// FIXME: this would be better to do using a filter
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		} else {
			req.setAttribute("username", user.getFirstname());
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
		else if (doSchedule != null && doSchedule.equals("true")) {
			//System.out.println("Account Page is true: " + doSchedule);
			resp.sendRedirect(req.getContextPath() + "/Schedule");
			return;
		}
		else if (doCalendar != null && doCalendar.equals("true")) {
			//System.out.println("Account Page is true: " + doSchedule);
			resp.sendRedirect(req.getContextPath() + "/Calendar");
			return;
		}
		else if (doGrades != null && doGrades.equals("true")) {
			//System.out.println("Account Page is true: " + doSchedule);
			resp.sendRedirect(req.getContextPath() + "/Grades");
			return;
		}
		else if (doAssignments != null && doAssignments.equals("true")) {
			//System.out.println("Account Page is true: " + doSchedule);
			resp.sendRedirect(req.getContextPath() + "/Assignments");
			return;
		}
		else if (doForums != null && doForums.equals("true")) {
			//System.out.println("Account Page is true: " + doSchedule);
			resp.sendRedirect(req.getContextPath() + "/Forums");
			return;
		}
		else {
			req.getRequestDispatcher("/_view/hub.jsp").forward(req, resp);
		}
		
		
	}
}
