package com.YCPCS.Whiteboard.Database;

public interface DatabaseLayer {
	
	//Should get the user ID given the username and password info
	//, If there is no such user return -1
	//Password is preferably stored in a hash
	public int getUserIDByLogin(String Username, String password);
	
	public String getNameFromId(int id);

}
