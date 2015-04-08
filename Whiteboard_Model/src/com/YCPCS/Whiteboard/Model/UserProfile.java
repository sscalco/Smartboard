package com.YCPCS.Whiteboard.Model;

import java.util.ArrayList;

public class UserProfile {
	private String username, firstName, lastName;
	private ArrayList<Class> classList = new ArrayList<Class>();
	
	public UserProfile(){
		
	}
	
	public UserProfile(String username){
		this.username = username;
	}
	
	public String getUsername(){
		return username;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public String getFullName(){
		return firstName + " " + lastName;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public void setFirstName(String name){
		this.firstName = name;
	}
	
	public void setLastName(String name){
		this.lastName = name;
	}
}
