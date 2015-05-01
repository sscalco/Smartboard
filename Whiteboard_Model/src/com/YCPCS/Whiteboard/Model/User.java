package com.YCPCS.Whiteboard.Model;

import java.sql.Date;
import java.util.ArrayList;

public class User {

	private int id;
	private String username;
	private String password;	//Should be storing the password as a hash
	private String firstname;
	private String lastname;
	private String email;
	private Date lastLoginDate;
	private ArrayList<Permission> permissions;
	private UserProfile profile;

	private ArrayList<Lecture> lectures = new ArrayList<Lecture>();

	
	public User(){
		profile = new UserProfile();
	}

	public User(String username, String password){
		this.username = username;
		this.password = password;
		profile = new UserProfile(username);
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
	
	public void setPermissions(ArrayList<Permission> permissions){
		this.permissions = permissions;
	}
	
	public ArrayList<Permission> getPermissions(){
		return permissions;
	}
	
	public void setLastLoginDate(Date date){
		this.lastLoginDate = date;
	}
	
	public Date getLastLoginDate(){
		return lastLoginDate;
	}
	
	public UserProfile getProfile(){
		return profile;
	}

	public ArrayList<Lecture> getLectures() {
		return lectures;
	}

	public void setLectures(ArrayList<Lecture> lectures) {
		this.lectures = lectures;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
