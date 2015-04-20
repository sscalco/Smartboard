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
		
		RelationshipController relCon = new RelationshipController();
		
		List<Relationship> rels = relCon.findRelationships("user", userId, "lecture");
		
		//for(Relationship rel : rels){
		//	assignments.add(getAssignmentFromId(rel.getTargetId()));
		//}
		
		return assignments;
		
	}
	
	public Lecture getLectureFromId(int id){
		return DatabaseProvider.getInstance().getClassById(id);
	}
	
}