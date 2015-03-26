package com.YCPCS.Whiteboard.Database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.YCPCS.Whiteboard.Model.*;

public class InitialData {

	
	public static List<User> getUsers() throws IOException {
		List<User> userList = new ArrayList<User>();
		ReadCSV readUsers = new ReadCSV("user.csv");
		try {
			while (true) {
				List<String> tuple = readUsers.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				User user = new User();
				user.setUsername(i.next());
				user.setPassword(i.next());
				user.setLastname(i.next());
				user.setFirstname(i.next());
				userList.add(user);
			}
			return userList;
		} finally {
			readUsers.close();
		}
	}

}
