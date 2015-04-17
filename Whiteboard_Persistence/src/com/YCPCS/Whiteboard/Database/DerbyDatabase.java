package com.YCPCS.Whiteboard.Database;

import java.util.List;

import com.YCPCS.Whiteboard.Model.Grade;
import com.YCPCS.Whiteboard.Model.Lecture;
import com.YCPCS.Whiteboard.Model.Relationship;
import com.YCPCS.Whiteboard.Model.User;

public class DerbyDatabase implements DatabaseLayer{

	@Override
	public int getUserIDByLogin(String Username, String password) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getFirstNameFromId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLastNameFromId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUserToDatabase(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Lecture getClassById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Relationship> getRelationshipsByRootAndTarget(String root,
			String target) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Grade getGradeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
