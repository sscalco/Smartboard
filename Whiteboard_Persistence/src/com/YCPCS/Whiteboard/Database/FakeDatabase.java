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
	private ArrayList<String> usernames;
	private ArrayList<String> passwords;
	private ArrayList<String> names = new ArrayList<String>();
	private ArrayList<Integer> userIds = new ArrayList<Integer>();
	
	public FakeDatabase() {
		usersList = new ArrayList<User>();
		classList = new ArrayList<Class>();
		// get initial data
		readInitialData();
	}
	
	public void readInitialData() {
		try {
			usersList.addAll(InitialData.getUsers());
			classList.addAll(InitialData.getClasses());
		} catch (IOException e) {
			throw new IllegalStateException("Couldn't read initial data", e);
		}
	}
	
	public int getUserIDByLogin(String Username, String password) {
		if(usernames.contains(Username)){
			int id = userIds.get(usernames.indexOf(Username));
			if(passwords.get(id).equals(password)){
				return id;
			}
		}
		return -1;
	}

	public String getNameFromId(int id) {
		if(userIds.contains(id)){
			int index = userIds.indexOf(id);
			return names.get(index);
		}else{
			return null;
		}
	}

	//TODO: Implement
	public String getFirstNameFromId(int id) {
		return null;
	}

	//TODO: Implement
	public String getLastNameFromId(int id) {
		return null;
	}
	
	

}
