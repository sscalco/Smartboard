package com.YCPCS.JUnitTests;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.YCPCS.Whiteboard.Controller.LectureController;
import com.YCPCS.Whiteboard.Database.DatabaseProvider;
import com.YCPCS.Whiteboard.Database.FakeDatabase;
import com.YCPCS.Whiteboard.Database.InitialData;
import com.YCPCS.Whiteboard.Model.Assignment;
import com.YCPCS.Whiteboard.Model.Grade;
import com.YCPCS.Whiteboard.Model.Lecture;
import com.YCPCS.Whiteboard.Model.User;
import com.YCPCS.Whiteboard.Model.UserProfile;
import com.YCPCS.Whiteboard.Model.Relationship;
import com.YCPCS.Whiteboard.Model.Permission;


public class JUnitTests extends TestCase{
	User user = new User();
	UserProfile profile = new UserProfile();
	Lecture lecture = new Lecture();
	Lecture aClass = new Lecture();
	FakeDatabase db = new FakeDatabase();
	ArrayList<User> students = new ArrayList<User>();
	ArrayList<Assignment> assignments = new ArrayList<Assignment>();
	List<User> usersList = new ArrayList<User>();
	List<Lecture> lectureList = new ArrayList<Lecture>();
	List<Assignment> assignmentList = new ArrayList<Assignment>();
	List<Relationship> relationshipList = new ArrayList<Relationship>();
	List<Permission> permissionList = new ArrayList<Permission>();
	public void setUp(){
		try {
			usersList.addAll(InitialData.getUsers());
			lectureList.addAll(InitialData.getClasses());
			assignmentList.addAll(InitialData.getAssignments());
			relationshipList.addAll(InitialData.getRelationships());
			permissionList.addAll(InitialData.getPermission());
		} catch (IOException e) {
			throw new IllegalStateException("Couldn't read initial data", e);
		}
	}
	public void testSetUsername(){
		user.setUsername("User");
		assertEquals("User", user.getUsername());
	}
	
	public void testSetFirstName(){
		user.setFirstname("David");
		assertEquals("David", user.getFirstname());
	}
	
	public void testSetLastName(){
		user.setLastname("Hoevemeyer");
		assertEquals("Hoevemeyer", user.getLastname());
	}
	
	public void testSetPassword(){
		user.setPassword("Bojangle");
		assertEquals("Bojangle", user.getPassword());
	}
	
	//UserProfile
	public void testSetUserProfileName(){
		profile.setUsername("Al458");
		assertEquals("Al458", profile.getUsername());
	}
	
	public void testSetFirstProfileName(){
		profile.setFirstName("Al");
		assertEquals("Al", profile.getFirstName());
	}
	
	public void testSetLastProfileName(){
		profile.setLastName("Higgins");
		assertEquals("Higgins", profile.getLastName());
	}
	
	public void testGetFullName(){
		profile.setFirstName("Al");
		profile.setLastName("Higgins");
		assertEquals("Al Higgins", profile.getFullName());
	}
	
	//Class	
	public void testSetClassSize(){
		aClass.setClassSize(30);
		assertEquals(30, aClass.getClassSize());
	}
	
	public void testAddStudent(){
		for(int i = 0; i < 5; i++)
			students.add(new User());
		for(int i = 0; i < 5; i++)
		{
			aClass.addStudent(students.get(i));
			assertEquals(students.get(i), aClass.getStudentList().get(i));
			assertEquals(i+1, aClass.getStudentList().size());
		}
	}
	
	public void testAddAssignment(){
		for(int i = 0; i < 5; i++)
			assignments.add(new Assignment());
		for(int i = 0; i < 5; i++)
		{
			aClass.addAssignment(assignments.get(i));
			assertEquals(assignments.get(i), aClass.getAssignments().get(i));
			assertEquals(i+1, aClass.getAssignments().size());
		}
	}
	
	// fake database
	public void testReadInitialData(){
		setUp();
		
		User user1 = usersList.get(0);
		assertEquals(0, user1.getId());
		assertEquals("nexion21",user1.getUsername());
		assertEquals("melons123",user1.getPassword());
		assertEquals("Todd",user1.getFirstname());
		assertEquals("Leach",user1.getLastname());
		
		Lecture class1 = lectureList.get(0);
		assertEquals(1, class1.getClassId());
		assertEquals("Computer Science 320", class1.getClassName());
		assertEquals("Is Awesome", class1.getClassDescription());
		assertEquals(15, class1.getClassSize());
		assertEquals("Hovemeyer", class1.getTeacher());
		
		Assignment assignment1 = assignmentList.get(0);
		assertEquals(0,assignment1.getId());
		assertEquals("Quiz 1", assignment1.getName());
		assertEquals(20, assignment1.getPointValue());
		assertEquals("20 questions pertaining to the philosophy of velociraptors", assignment1.getDescription());
	
		Relationship relationship1 = relationshipList.get(0);
		assertEquals(1, relationship1.getId());
		assertEquals("user", relationship1.getRoot());
		assertEquals("lecture", relationship1.getTarget());
		assertEquals(4, relationship1.getRootId());
		assertEquals(1, relationship1.getTargetId());
		
		Permission permission1 = permissionList.get(0);
		assertEquals(0, permission1.getId());
		assertEquals("addClass", permission1.getName());
		assertEquals(0, permission1.getUserId());
		assertEquals(false, permission1.isFruitcake());
	}
		
	public void testGetNameFromId(){
		setUp();
		assertEquals("Todd", db.getFirstNameFromId(0));
		assertEquals("Leach", db.getLastNameFromId(0));
	}
	
	public void testUserFromDatabase(){
		setUp();
		user.setFirstname(db.getFirstNameFromId(2));
		user.setLastname(db.getLastNameFromId(2));
		user.setId(db.getUserIDByLogin("koopaluigi", "toadstool"));
		profile = user.getProfile();
		profile.setFirstName(user.getFirstname());
		profile.setLastName(user.getLastname());
		assertEquals("Cooper", profile.getFirstName());
		assertEquals("Luetje", profile.getLastName());
		assertEquals("Cooper Luetje", profile.getFullName());
	}
	
	public void testGetClassSizeFromId(){
		setUp();
		assertEquals(15, db.getClassSizeFromId(1));
	}
	
	public void testRelationship(){
		DatabaseProvider.setInstance(new FakeDatabase());
		//System.out.println("Number Of Relationships: "+DatabaseProvider.getInstance().getRelationshipsByRootAndTarget("user", "lecture").size());
		int targetId = DatabaseProvider.getInstance().getRelationshipsByRootAndTarget("user", "lecture").get(0).getTargetId();
		//System.out.println("First relationship target id: " + targetId);
		Lecture lecture = DatabaseProvider.getInstance().getClassById(targetId);
		System.out.print(lecture.getClassName());
	}
	
	public void testUserClassRelationship(){
		
	}
	
	public void testGetUserByUsernameAndPassword(){
		
	}
	
	public void testAddUser(){
		User user = new User();
		int users = usersList.size();
		db.addUserToDatabase(user);
		assertEquals(users, usersList.size());
	}
	
	
	public void testGradeLetters(){
		Grade grade = new Grade();
		grade.setGrade(89.5);
		assertEquals(89.5, grade.getGrade());
		assertEquals("A", grade.getLetter());
	}
	
	// real database
	public void testGetUserIDByLogin(){
		
	}
}
