package com.YCPCS.Whiteboard.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.YCPCS.Whiteboard.Database.DatabaseProvider;
import com.YCPCS.Whiteboard.Database.DerbyDatabase;
import com.YCPCS.Whiteboard.Database.FakeDatabase;

public class DatabaseInitListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent e) {
		// Create an install an implementation of the persistence layer
		//System.out.println("Installing FakeDatabase as the database provider");
		//DatabaseProvider.setInstance(new FakeDatabase());
		System.out.println("Installing DerbyDatabase as the database provider");
		DatabaseProvider.setInstance(new DerbyDatabase());
	}

	@Override
	public void contextDestroyed(ServletContextEvent e) {
		// Nothing to do
	}

}
