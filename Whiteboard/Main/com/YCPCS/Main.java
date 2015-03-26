package com.YCPCS;

import java.io.IOException;
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
		}
		
		System.out.println("Server Shutting Down");
		server.stop();
		keyboard.close();
		System.exit(0);
	}
	
}
