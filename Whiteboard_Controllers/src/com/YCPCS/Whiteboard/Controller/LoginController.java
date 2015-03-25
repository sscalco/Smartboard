package com.YCPCS.Whiteboard.Controller;

import com.YCPCS.Whiteboard.Model.User;

public class LoginController {
	
	public LoginController(){
		
	}
	
	public void tryLoginQuery(){
		
	}

	public User findUser(String username, String password) {
		
		return new User(username, password);
	}

}
