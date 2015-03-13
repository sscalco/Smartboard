package com.YCPCS;

public class User {

	private String username;
	private String password;
	private String firstName;
	private String lastName;
	
	public User(){
		
	}
	
	public User(String username, String password){
		this.username = username;
		this.password = password;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public String getUsername(){
		return this.username;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public void setFirstName(String name){
		this.firstName = name;
	}
	
	public String getFirstName(){
		return this.firstName;
	}
	
	public void setLastName(String name){
		this.lastName = name;
	}
	
	public String getLastName(){
		return this.lastName;
	}
	
}
