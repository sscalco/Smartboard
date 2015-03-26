package com.YCPCS.Whiteboard.Database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.YCPCS.Whiteboard.Database.InitialData;
import com.YCPCS.Whiteboard.Model.*;

public class FakeDatabase implements DatabaseLayer{
	private List<User> usersList;
	
	public FakeDatabase() {
		usersList = new ArrayList<User>();
		readInitialData();
	}
	
	public void readInitialData() {
		try {
			usersList.addAll(InitialData.getUsers());
		} catch (IOException e) {
			throw new IllegalStateException("Couldn't read initial data", e);
		}
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
				return user.getFirstname();
			}
		}
		return null;
	}
	
	

}
