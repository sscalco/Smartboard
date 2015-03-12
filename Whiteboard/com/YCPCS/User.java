package com.YCPCS;

public class User {

	private String username;
	private String password;
	private String firstname;
	private String lastname;
	
	public User(){
		
	}
	
	public User(String username, String password){
		this.username = username;
		this.password = password;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public void setFirstName(String name){
		this.firstname = name;
	}
	
}
