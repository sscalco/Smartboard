package com.YCPCS;

import java.sql.Date;

public class User {

	private int id;
	private String username;
	private String password;	//Should be storing the password as a hash
	private String firstname;
	private String lastname;
	private Date lastLoginDate;
	private WhiteboardPermissions permissions;

	
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
	
	public void setFirstname(String name){
		this.firstname = name;
	}
	
	public void setLastname(String name){
		this.lastname = name;
	}
	
	public String getFirstname(){
		return this.firstname;
	}
	
	public String getLastname(){
		return lastname;
	}
	
	public String getUsername(){
		return username;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPermissions(WhiteboardPermissions permissions){
		this.permissions = permissions;
	}
	
	public WhiteboardPermissions getPermissions(){
		return permissions;
	}
	
	public void setLastLoginDate(Date date){
		this.lastLoginDate = date;
	}
	
	public Date getLastLoginDate(){
		return lastLoginDate;
	}
}
