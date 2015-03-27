package com.YCPCS.Whiteboard.Controller;

import com.YCPCS.Whiteboard.Database.DatabaseLayer;
import com.YCPCS.Whiteboard.Database.DatabaseProvider;
import com.YCPCS.Whiteboard.Model.User;

public class LoginController {
	
	public LoginController(){
		
	}
	
	public void tryLoginQuery(){
		
	}

	public User findUser(String username, String password) {
		
		DatabaseLayer database = DatabaseProvider.getInstance();
		
		return database.getUserByUsernameAndPassword(username, password);
	}

}
