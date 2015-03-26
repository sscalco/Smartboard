package com.YCPCS.Whiteboard.Database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.YCPCS.Whiteboard.DBModel.*;

public class InitialData {
	public static List<Username> getUsernames() throws IOException {
		List<Username> usernameList = new ArrayList<Username>();
		ReadCSV readUsernames= new ReadCSV("usernames.csv");
		
		try {
			while (true) {
				List<String> tuple = readUsernames.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Username username = new Username();
				username.setUsername(i.next());
				usernameList.add(username);
			}
		
			return usernameList;
		
		} finally {
			readUsernames.close();
		}
	}
	
	public static List<Password> getPasswords() throws IOException {
		List<Password> passwordList = new ArrayList<Password>();
		ReadCSV readPasswords= new ReadCSV("passwords.csv");
		
		try {
			while (true) {
				List<String> tuple = readPasswords.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Password password = new Password();
				password.setPassword(i.next());
				passwordList.add(password);
			}
		
			return passwordList;
		
		} finally {
			readPasswords.close();
		}
	}
}
