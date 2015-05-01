package com.YCPCS.Whiteboard.Database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.YCPCS.Whiteboard.Database.InitialData;
import com.YCPCS.Whiteboard.Model.*;

public class FakeDatabase implements DatabaseLayer{
	private List<User> usersList;
	private List<Lecture> classList;
	private List<Assignment> assignmentList;
	private List<Relationship> relationshipList;
	private List<Grade> gradeList;
	
	//Below is covered in the user class
	//private ArrayList<String> usernames;
	//private ArrayList<String> passwords;
	//private ArrayList<String> names = new ArrayList<String>();
	//private ArrayList<Integer> userIds = new ArrayList<Integer>();
	
	
	public FakeDatabase() {
		usersList = new ArrayList<User>();
		classList = new ArrayList<Lecture>();
		assignmentList = new ArrayList<Assignment>();
		relationshipList = new ArrayList<Relationship>();
		gradeList = new ArrayList<Grade>();
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
			relationshipList.addAll(InitialData.getRelationships());
			gradeList.addAll(InitialData.getGrades());
		} catch (IOException e) {
			throw new IllegalStateException("Couldn't read initial data", e);
		}
	}
	
	// grade
	public float getGradeByAssignmentID(int id) {
		for (Assignment assign : assignmentList){
			if (assign.getId() == id){
				return assign.getAssignmentGrade();
			}
		}
		
		return -1;
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
		for (Lecture class1 : classList){
			if(class1.getClassId()==id){
				return class1.getClassName();
			}
		}
		return null;
	}
	
	public String getClassDescriptionFromId(int id){
		for (Lecture class1 : classList){
			if(class1.getClassId()==id){
				return class1.getClassDescription();
			}
		}
		return null;
	}
	
	public int getClassSizeFromId(int id){
		for (Lecture class1 : classList){
			if(class1.getClassId()==id){
				return class1.getClassSize();
			}
		}
		return 0;
	}

	public Lecture getClassById(int id) {
		for(Lecture lecture : classList){
			if(lecture.getClassId()==id){
				return lecture;
			}
		}
		return null;
	}

	public List<Relationship> getRelationshipsByRootAndTarget(String root, String target) {
		List<Relationship> relList = new ArrayList<Relationship>();
		for(Relationship rel : relationshipList){
			if(rel.getRoot().equals(root) && rel.getTarget().equals(target)){
				relList.add(rel);
			}
		}
		return relList;
	}

	public Grade getGradeById(int id) {
		for(Lecture lecture: classList){
			if(lecture.getClassId()==id)
				return lecture.getGrade();
		}
		return null;
	}

	@Override
	public void addRelationship(Relationship r) {
		relationshipList.add(r);
	}

	@Override
	public Assignment getAssignmentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
