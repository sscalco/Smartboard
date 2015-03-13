package com.YCPCS;
import java.util.ArrayList;

public class Class 
{
	//Declare Variables
	private int classSize = 0;
	private ArrayList<User> students = new ArrayList<User>();
	private ArrayList<Assignment> assignments = new ArrayList<Assignment>();
	private Schedule schedule;
	private Forum forum;
	private Calendar calendar;
	public Class()
	{
		
	}
	
	public Class(int classSize)
	{
		this.classSize = classSize;
	}

	public int getClassSize()
	{
		return classSize;
	}
	
	//Used by Teacher Role
	public void setClassSize(int classSize)
	{
		this.classSize = classSize;
	}
	
	public Schedule getSchedule()
	{
		return schedule;
	}
	
	public Forum getForum()
	{
		return forum;
	}
	
	public Calendar getCalendar()
	{
		return calendar;
	}
	
	public ArrayList<User> getStudentList()
	{
		return students;
	}
	
	//Used by Teacher Role
	public void addStudent(User user)
	{
		students.add(user);
	}
	
	public ArrayList<Assignment> getAssignments()
	{
		return assignments;
	}
	
	//Used by Teacher Role
	public void addAssignment(Assignment assignment)
	{
		assignments.add(assignment);
	}
}
