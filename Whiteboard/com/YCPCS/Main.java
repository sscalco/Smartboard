package com.YCPCS;

import java.util.Scanner;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.webapp.WebAppContext;

public class Main {

	public static void main(String[] args) throws Exception{
		Server server = new Server(8081);

		// Create and register a webapp context
		WebAppContext handler = new WebAppContext();
		handler.setContextPath("/Whiteboard");
		handler.setWar("./war"); // web app is in the war directory of the project
		server.setHandler(handler);
		
		// Use 20 threads to handle requests
		//server.setThreadPool(new QueuedThreadPool(20));
		
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
		System.exit(0);
	}
	
}
