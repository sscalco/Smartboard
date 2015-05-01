package com.YCPCS.Whiteboard.Controller;

import java.util.ArrayList;
import java.util.List;

import com.YCPCS.Whiteboard.Database.DatabaseProvider;
import com.YCPCS.Whiteboard.Model.Assignment;
import com.YCPCS.Whiteboard.Model.Lecture;
import com.YCPCS.Whiteboard.Model.Relationship;

public class AssignmentController {
	
	public AssignmentController(){
		
	}
	
	public List<Assignment> getAllUserAssignments(int userId){
		
		List<Assignment> assignments = new ArrayList<Assignment>();
		
		List<Relationship> rels = DatabaseProvider.getInstance().getTarget("user", "lecture", userId);
		if(rels != null){
			for(Relationship rel : rels){
				assignments.add(DatabaseProvider.getInstance().getAssignmentById(rel.getTargetId()));
			}
		}
		return assignments;
		
	}
	
	public Lecture getLectureFromId(int id){
		return DatabaseProvider.getInstance().getClassById(id);
	}
	
}