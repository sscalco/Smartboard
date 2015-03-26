package com.YCPCS.JUnitTests;

import com.YCPCS.Whiteboard.Model.User;
import com.YCPCS.Whiteboard.Model.Class;
import com.YCPCS.Whiteboard.Model.Assignment;
import com.YCPCS.Whiteboard.Model.UserProfile;

import junit.framework.TestCase;

import java.util.ArrayList;

public class JUnitTests extends TestCase{
	User user = new User();
	UserProfile profile = user.getProfile();
	Class aClass = new Class();
	ArrayList<User> students = new ArrayList<User>();
	ArrayList<Assignment> assignments = new ArrayList<Assignment>();
	
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
}
