package com.YCPCS.Whiteboard.Database;

import com.YCPCS.Whiteboard.Model.User;

public interface DatabaseLayer {
	
	//Should get the user ID given the username and password info
	//, If there is no such user return -1
	//Password is preferably stored in a hash
	public int getUserIDByLogin(String Username, String password);
	
	public String getFirstNameFromId(int id);
	
	public String getLastNameFromId(int id);
	
	public User getUserByUsernameAndPassword(String username, String password);
	
	public void addUserToDatabase(User user);

}
