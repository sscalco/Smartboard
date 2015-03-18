package com.YCPCS.Whiteboard.Database;

import java.util.ArrayList;

public class FakeDatabase implements DatabaseLayer{

	private ArrayList<String> usernames = new ArrayList<String>();
	private ArrayList<String> passwords = new ArrayList<String>();
	private ArrayList<String> names = new ArrayList<String>();
	private ArrayList<Integer> userIds = new ArrayList<Integer>();
	
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
	
	

}
