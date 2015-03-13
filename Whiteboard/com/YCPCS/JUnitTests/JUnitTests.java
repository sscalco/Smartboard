package com.YCPCS.JUnitTests;

import com.YCPCS.User;

import junit.framework.TestCase;

public class JUnitTests extends TestCase{
	User user = new User();
	
	public void testSetUsername(){
		user.setUsername("User");
		assertEquals("User", user.getUsername());
	}
	
	public void testSetFirstName(){
		user.setUsername("David");
		assertEquals("David", user.getFirstname());
	}
	
	public void testSetLastName(){
		user.setUsername("Hoevemeyer");
		assertEquals("Hoevemeyer", user.getLastname());
	}
	
	public void testSetPassword(){
		user.setUsername("Bojangle");
		assertEquals("Bojangle", user.getPassword());
	}
}
