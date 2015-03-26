package com.YCPCS.JUnitTests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.YCPCS.Whiteboard.Database.InitialData;
import com.YCPCS.Whiteboard.Model.Assignment;
import com.YCPCS.Whiteboard.Model.Class;
import com.YCPCS.Whiteboard.Model.User;

public class JUnitTests extends TestCase{
	User user = new User();
	Class aClass = new Class();
	ArrayList<User> students = new ArrayList<User>();
	ArrayList<Assignment> assignments = new ArrayList<Assignment>();
	List<User> usersList = new ArrayList<User>();
	
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
		try {
			usersList.addAll(InitialData.getUsers());
		} catch (IOException e) {
			throw new IllegalStateException("Couldn't read initial data", e);
		}
		
		User user1 = usersList.get(0);
		assertEquals("Nexion21",user1.getUsername());
		assertEquals("melons123",user1.getPassword());
		assertEquals("Todd",user1.getFirstname());
		assertEquals("Leach",user1.getLastname());
			
	}
}
