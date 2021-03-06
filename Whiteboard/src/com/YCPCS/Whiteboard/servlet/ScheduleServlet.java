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

public class ScheduleServlet extends HttpServlet {
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
		//String scheduleCode = "";
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
//		else {
//			int userId = user.getId();
//			//TODO: Make more secure
//			LectureController cont = new LectureController();
//			ArrayList<Lecture> lectures = (ArrayList<Lecture>) cont.getAllUserLectures(userId);
//			System.out.println(lectures.size());
//			for(Lecture lecture : lectures){
//				String temp = 
//					"<div id=\"Class\">"+
//						"<h2>"+lecture.getClassName()+"</h2>"+
//						"<h3>Professor: "+lecture.getTeacher()+"</h3>"+
//						"<div id=\"ClassOptions\">"+
//							"<TR>"+ 
//								"<TD ALIGN=center>Sun</TD>"+
//								"<TD ALIGN=center>Mon</TD>"+
//								"<TD ALIGN=center>Tue</TD>"+
//								"<TD ALIGN=center>Wed</TD>"+
//								"<TD ALIGN=center>Thu</TD>"+
//								"<TD ALIGN=center>Fri</TD>"+
//								"<TD ALIGN=center>Sat</TD>"+
//							"</TR>"+
//							"<TR>"+ 
//								"<TD ALIGN=center></TD>"+
//								"<TD ALIGN=center></TD>"+
//								"<TD ALIGN=center></TD>"+
//								"<TD ALIGN=center></TD>"+
//								"<TD ALIGN=center></TD>"+
//								"<TD ALIGN=center></TD>"+
//								"<TD ALIGN=center></TD>"+
//							"</TR>"+
//						"</div>"+
//					"</div>";
//				
//				scheduleCode += temp;
//			}
//			
//			req.setAttribute("scheduleHTML", scheduleCode);
//		}
		else {
			req.getRequestDispatcher("/_view/Schedule.jsp").forward(req, resp);
		}
	}
}

