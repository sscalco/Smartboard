package com.YCPCS.Whiteboard.Model;

public class Class {
	private int classID;
	private User classProfessor;
	private Schedule classSchedule;
	private Assignment classAssignment;
	private Forum classForum;
	private User classStudent;

	
	public int getClassID() {
		return classID;
	}
	public void setClassID(int classID) {
		this.classID = classID;
	}
	
	public User getClassProfessor() {
		return classProfessor;
	}
	public void setClassProfessor(User classProfessor) {
		this.classProfessor = classProfessor;
	}
	
	public Schedule getClassSchedule() {
		return classSchedule;
	}
	public void setClassSchedule(Schedule classSchedule) {
		this.classSchedule = classSchedule;
	}
	
	public Assignment getClassAssignment() {
		return classAssignment;
	}
	public void setClassAssignment(Assignment classAssignment) {
		this.classAssignment = classAssignment;
	}
	
	public Forum getClassForum() {
		return classForum;
	}
	public void setClassForum(Forum classForum) {
		this.classForum = classForum;
	}
	
	public User getClassStudent() {
		return classStudent;
	}
	public void setClassStudent(User classStudent) {
		this.classStudent = classStudent;
	}
}
