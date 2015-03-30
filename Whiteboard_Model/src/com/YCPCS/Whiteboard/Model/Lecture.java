package com.YCPCS.Whiteboard.Model;
import java.util.ArrayList;

public class Lecture 
{
	//Declare Variables
	private int classSize = 0;
	private int classId;
	private String className;
	private String teacher;
	private String classDescription;
	private ArrayList<User> students = new ArrayList<User>();
	private ArrayList<Assignment> assignments = new ArrayList<Assignment>();
	private Schedule schedule;
	private Forum forum;
	private Calendar calendar;
	
	public Lecture()
	{
		
	}
	
	public Lecture(int classSize){
		this.classSize = classSize;
	}
	
	public int getClassId(){
		return this.classId;
	}
	
	public void setClassId(int id){
		this.classId = id;
	}
	
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
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
	
	public String getClassDescription() {
		return classDescription;
	}

	public void setClassDescription(String classDescription) {
		this.classDescription = classDescription;
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
		setClassSize(getStudentList().size());
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

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

}
