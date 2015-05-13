package com.YCPCS.Whiteboard.Database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.YCPCS.Whiteboard.Model.*;

import dbUtils.ReadCSV;

public class InitialData {
	
	public static List<User> getUsers() throws IOException {
		List<User> userList = new ArrayList<User>();
		ReadCSV readUsers = new ReadCSV("Users.csv");
		try {
			while (true) {
				List<String> tuple = readUsers.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				User user = new User();
				user.setId(Integer.parseInt(i.next()));
				user.setUsername(i.next());
				user.setPassword(i.next());
				user.setLastname(i.next());
				user.setFirstname(i.next());
				user.setEmail(i.next());
				
				userList.add(user);
			}
			return userList;
		} finally {
			readUsers.close();
		}
	}

	public static List<Lecture> getClasses() throws IOException {
		List<Lecture> classList = new ArrayList<Lecture>();
		ReadCSV readClasses = new ReadCSV("Classes.csv");
		try {
			while (true) {
				List<String> tuple = readClasses.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Lecture class1 = new Lecture();
				class1.setClassId(Integer.parseInt(i.next()));
				class1.setClassName(i.next());
				class1.setClassDescription(i.next());
				class1.setClassSize(Integer.parseInt(i.next()));
				class1.setTeacherId(Integer.parseInt(i.next()));
				classList.add(class1);
			}
			return classList;
		} finally {
			readClasses.close();
		}
	}
	
	public static List<Assignment> getAssignments() throws IOException {
		List<Assignment> assignmentList = new ArrayList<Assignment>();
		ReadCSV readAssignments = new ReadCSV("Assignments.csv");
		try {
			while (true) {
				List<String> tuple = readAssignments.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Assignment assign = new Assignment();
				assign.setId(Integer.parseInt(i.next()));
				assign.setName(i.next());
				assign.setPointValue(Integer.parseInt(i.next()));
				assign.setDescription(i.next());
				
				assignmentList.add(assign);
			}
			return assignmentList;
		} finally {
			readAssignments.close();
		}
	}
	
	public static List<Relationship> getRelationships() throws IOException {
		List<Relationship> relationshipList = new ArrayList<Relationship>();
		ReadCSV readRelationships = new ReadCSV("Relationships.csv");
		try {
			while (true) {
				List<String> tuple = readRelationships.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Relationship rel = new Relationship();
				rel.setId(Integer.parseInt(i.next()));
				rel.setTarget(i.next());
				rel.setRoot(i.next());
				rel.setTargetId(Integer.parseInt(i.next()));
				rel.setRootId(Integer.parseInt(i.next()));
				
				relationshipList.add(rel);
			}
			return relationshipList;
		} finally {
			readRelationships.close();
		}
	}
	
	public static List<Permission> getPermission() throws IOException {
		List<Permission> permissionList = new ArrayList<Permission>();
		ReadCSV permissionsList = new ReadCSV("Permissions.csv");
		try {
			while (true) {
				List<String> tuple = permissionsList.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Permission permission = new Permission();
				permission.setId(Integer.parseInt(i.next()));
				permission.setName(i.next());
				permission.setUserId(Integer.parseInt(i.next()));
				permission.setFruitcake(Boolean.getBoolean(i.next()));
				permissionList.add(permission);
			}
			return permissionList;
		} finally {
			permissionsList.close();
		}
	}
	
	public static List<Lecture> getLecture() throws IOException {
		List<Lecture> List = new ArrayList<Lecture>();
		ReadCSV readList = new ReadCSV("Lectures.csv");
		try {
			while (true) {
				List<String> tuple = readList.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Lecture lecture = new Lecture();
				lecture.setClassId(Integer.parseInt(i.next()));
				lecture.setClassName(i.next());
				lecture.setClassSize(Integer.parseInt(i.next()));
				lecture.setGrade(Float.parseFloat(i.next()));
				lecture.setTeacher(i.next());
				lecture.setClassDescription(i.next());
				List.add(lecture);
			}
			return List;
		} finally {
			readList.close();
		}
	}
}
	
