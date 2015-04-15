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

public class LectureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doRequest(req, resp);
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doRequest(req, resp);
	}
	
	private void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String classCode = "";
		
		User user = (User) req.getSession().getAttribute("user");
		
		if(user == null){
			resp.encodeRedirectURL("/login");
			return;
		}else{
			
			int userId = user.getId();
			//TODO: Make more secure
			LectureController cont = new LectureController();
			ArrayList<Lecture> lectures = (ArrayList<Lecture>) cont.getAllUserLectures(userId);
			System.out.println(lectures.size());
			for(Lecture lecture : lectures){
				String temp = 
					"<div id=\"Class\">"+
						"<h2>"+lecture.getClassName()+"</h2>"+
						"<h3>Professor: "+lecture.getTeacher()+"</h3>"+
						"<div id=\"ClassOptions\">"+
							"<p>Schedule</p>"+
							"<p>Assignments</p>"+
							"<p>Forum</p>"+
							"<p>Grades</p>"+
						"</div>"+
					"</div>";
				
				classCode += temp;
			}
			
			req.setAttribute("classHTML", classCode);
			req.getRequestDispatcher("/_view/Lecture.jsp").forward(req, resp);
		}
	}
}
