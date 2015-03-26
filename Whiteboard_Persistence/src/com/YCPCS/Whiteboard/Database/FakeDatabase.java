package com.YCPCS.Whiteboard.Database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.YCPCS.Whiteboard.Database.InitialData;

import com.YCPCS.Whiteboard.DBModel.*;

public class FakeDatabase implements DatabaseLayer{

	private List<Username> usernames;
	private List<Password> passwords;
	private ArrayList<String> names = new ArrayList<String>();
	private ArrayList<Integer> userIds = new ArrayList<Integer>();
	
	public FakeDatabase() {
		usernames = new ArrayList<Username>();
		passwords = new ArrayList<Password>();
		// get initial data
		//readInitialData();
	}
	
	public void readInitialData() {
		try {
			usernames.addAll(InitialData.getUsernames());
			passwords.addAll(InitialData.getPasswords());
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
