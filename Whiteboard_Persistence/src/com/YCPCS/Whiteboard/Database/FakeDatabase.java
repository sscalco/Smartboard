package com.YCPCS.Whiteboard.Database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.YCPCS.Whiteboard.Database.InitialData;
import com.YCPCS.Whiteboard.Model.*;
import com.YCPCS.Whiteboard.Model.Class;

public class FakeDatabase implements DatabaseLayer{
	private List<User> usersList;
	private List<Class> classList;
	private List<Assignment> assignmentList;
	private ArrayList<String> usernames;
	private ArrayList<String> passwords;
	private ArrayList<String> names = new ArrayList<String>();
	private ArrayList<Integer> userIds = new ArrayList<Integer>();
	
	
	public FakeDatabase() {
		usersList = new ArrayList<User>();
		classList = new ArrayList<Class>();
		assignmentList = new ArrayList<Assignment>();
		// get initial data
		readInitialData();
	}
	
	public void addUserToDatabase(User user){
		usersList.add(user);
	}
	
	public void readInitialData() {
		try {
			usersList.addAll(InitialData.getUsers());
			classList.addAll(InitialData.getClasses());
			assignmentList.addAll(InitialData.getAssignments());
		} catch (IOException e) {
			throw new IllegalStateException("Couldn't read initial data", e);
		}
	}
	
	// user 
	public User getUserByUsernameAndPassword(String username, String password){
		if(username!=null && password!=null){
			for(User user : usersList){
				if(user.getUsername().equals(username) && user.getPassword().equals(password)){
					return user;
				}
			}
		}
		return null;
	}
	
	public int getUserIDByLogin(String Username, String password) {
		for(User user : usersList){
			if(user.getUsername().equals(Username) && user.getPassword().equals(password)){
				return user.getId();
			}
		}
		return -1;
	}

	public String getFirstNameFromId(int id) {
		for(User user : usersList){
			if(user.getId()==id){
				return user.getFirstname();
			}
		}
		return null;
	}

	public String getLastNameFromId(int id) {
		for(User user : usersList){
			if(user.getId()==id){
				return user.getLastname();
			}
		}
		return null;
	}
	
	// class
	public String getClassNameFromId(int id){
		for (Class class1 : classList){
			if(class1.getClassId()==id){
				return class1.getClassName();
			}
		}
		return null;
	}
	
	public String getClassDescriptionFromId(int id){
		for (Class class1 : classList){
			if(class1.getClassId()==id){
				return class1.getClassDescription();
			}
		}
		return null;
	}
	
	public int getClassSizeFromId(int id){
		for (Class class1 : classList){
			if(class1.getClassId()==id){
				return class1.getClassSize();
			}
		}
		return 0;
	}
}
