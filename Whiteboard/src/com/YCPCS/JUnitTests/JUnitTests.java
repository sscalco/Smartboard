package com.YCPCS.JUnitTests;

import com.YCPCS.Whiteboard.Model.User;

import junit.framework.TestCase;

public class JUnitTests extends TestCase{
	User user = new User();
	
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
}
