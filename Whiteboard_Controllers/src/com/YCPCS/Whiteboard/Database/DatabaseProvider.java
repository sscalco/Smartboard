package com.YCPCS.Whiteboard.Database;

public class DatabaseProvider {
	private static DatabaseLayer theInstance;
	
	public static void setInstance(DatabaseLayer instance) {
		theInstance = instance;
	}
	
	public static DatabaseLayer getInstance() {
		if (theInstance == null) {
			throw new IllegalStateException("There is no implementation of DatabaseLayer!");
		}
		return theInstance;
	}
}
