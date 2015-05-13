package com.YCPCS;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.webapp.WebAppContext;

import com.YCPCS.Whiteboard.Database.DatabaseProvider;
import com.YCPCS.Whiteboard.Model.Lecture;
import com.YCPCS.Whiteboard.Model.User;

public class Main {

	private static class BadUrlRedirectHandler extends AbstractHandler {
		@Override
		public void handle(String target, Request baseRequest,
				HttpServletRequest request, HttpServletResponse response)
						throws IOException, ServletException {
			response.sendRedirect("/Whiteboard/login");
		}
	}

	public static void main(String[] args) throws Exception{
		Server server = new Server(8081);
		// Create and register a webapp context
		WebAppContext webappHandler = new WebAppContext();
		webappHandler.setContextPath("/Whiteboard");
		webappHandler.setWar("./war"); // web app is in the war directory of the project
		webappHandler.setInitParameter("org.eclipse.jetty.servlet.Default.dirAllowed", "false");

		HandlerList handlerList = new HandlerList();

		handlerList.addHandler(webappHandler);

		BadUrlRedirectHandler badUrlRedirectHandler = new BadUrlRedirectHandler();
		handlerList.addHandler(badUrlRedirectHandler);


		server.setHandler(handlerList);

		// Use 20 threads to handle requests
		server.setThreadPool(new QueuedThreadPool(20));

		// Start the server
		server.start();

		System.out.println("Server Started!");
		System.out.println("Enter (stop) to stop server!");

		Scanner keyboard = new Scanner(System.in);
		String input = keyboard.nextLine().toLowerCase().trim();

		while(!input.equals("stop")){
			System.out.println(input);
			input = keyboard.nextLine().toLowerCase().trim();

			if(input.startsWith("/")){
				if(input.contains("create user")){
					String[] temp = input.split(" ");
					if(temp.length!=7){
						System.out.println("Error!\n Adding a user should be in the form+"
								+ "create user [Username] [Password] [Firstname] [Lastname] [Email]");

					}else{
						User user = new User();
						user.setUsername(temp[2]);
						user.setPassword(temp[3]);
						user.setFirstname(temp[4]);
						user.setLastname(temp[5]);
						user.setEmail(temp[6]);
						try{
							DatabaseProvider.getInstance().addUserToDatabase(user);
						}catch(NullPointerException e){
							System.out.println("Error The Database is not available");
						}
						System.out.println("User created");
						System.out.println("Username: "+temp[2]);
						System.out.println("Password: "+temp[3]);
					}
				}
				if(input.contains("create class")){
					String[] temp = input.split(" ");

					if(temp.length != 6){
						System.out.println("Error!\n Adding a user should be in the form+"
								+ "create class [Name] [Teacher_Name] [Class_Description] [Class_Size]");
					}else{
						try{
							Lecture lecture = new Lecture();
							lecture.setClassName(temp[2]);
							lecture.setTeacherId(Integer.parseInt(temp[3]));
							lecture.setClassDescription(temp[4]);
							lecture.setClassSize(Integer.parseInt(temp[5]));
							DatabaseProvider.getInstance().addClass(lecture);
						}catch(Exception e){

						}
						System.out.println("Class created");
						System.out.println("Class Name: "+temp[2]);
					}
				}
				if(input.contains("show users")){
					List<User> users = DatabaseProvider.getInstance().getAllUsers();
					System.out.println("Showing Users");
					for(User u : users){
						System.out.println("User ("+u.getId()+")"
								+ "Username: "+u.getUsername()+" Password: "+u.getPassword()+" Name: "+u.getFirstname()+" "+u.getLastname());
					}
				}
			}
		}

		System.out.println("Server Shutting Down");
		server.stop();
		keyboard.close();
		System.exit(0);
	}

}
