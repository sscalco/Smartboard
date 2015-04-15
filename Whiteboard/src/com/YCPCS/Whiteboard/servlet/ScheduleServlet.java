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

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doRequest(req, resp);
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doRequest(req, resp);
	}
	
	private void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String classCode = "TEST";
		
		User user = (User) req.getSession().getAttribute("user");
		
		if(user == null){
			resp.encodeRedirectURL("/login");
			return;
		}
	}
}
