package com.YCPCS.Whiteboard.Model;

import java.sql.Date;
import java.util.ArrayList;

public class User {

	private int id;
	private String username;
	private String password;	//Should be storing the password as a hash
	private String firstname;
	private String lastname;
	private Date lastLoginDate;
	private WhiteboardPermissions permissions;
	private ArrayList<Lecture> lectures = new ArrayList<Lecture>();

	
	public User(){
		
	}

	public User(String username, String password){
		this.username = username;
		this.password = password;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public void setLastname(String name){
		this.lastname = name;
	}
	
	public void setFirstname(String name){
		this.firstname = name;
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

	public ArrayList<Lecture> getLectures() {
		return lectures;
	}

	public void setLectures(ArrayList<Lecture> lectures) {
		this.lectures = lectures;
	}
}
