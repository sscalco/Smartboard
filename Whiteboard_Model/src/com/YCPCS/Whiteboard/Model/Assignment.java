package com.YCPCS.Whiteboard.Model;

public class Assignment {

	private int id;
	private int pointValue;
	private String name;
	private String description;
	private float assignmentGrade;
	private String teacherName;
	private float dueDate;
	
	public Assignment(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPointValue() {
		return pointValue;
	}

	public void setPointValue(int pointValue) {
		this.pointValue = pointValue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

	public float getAssignmentGrade() {
		return assignmentGrade;
	}

	public void setAssignmentGrade(float assignmentGrade) {
		this.assignmentGrade = assignmentGrade;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public float getDueDate() {
		return dueDate;
	}

	public void setDueDate(float dueDate) {
		this.dueDate = dueDate;
	}
}
