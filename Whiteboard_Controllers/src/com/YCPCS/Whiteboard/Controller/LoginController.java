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
		
		int userId = database.getUserIDByLogin(username, password);
		
		if(userId==-1){
			return null;
		}else{
			User user = new User(username, password);
			user.setFirstname(database.getFirstNameFromId(userId));
		}
		
		return new User(username, password);
	}

}
