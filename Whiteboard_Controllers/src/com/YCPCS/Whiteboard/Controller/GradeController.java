package com.YCPCS.Whiteboard.Controller;

import java.util.ArrayList;
import java.util.List;

import com.YCPCS.Whiteboard.Database.DatabaseProvider;
import com.YCPCS.Whiteboard.Model.Grade;
import com.YCPCS.Whiteboard.Model.Lecture;
import com.YCPCS.Whiteboard.Model.Relationship;

public class GradeController {

	public GradeController()
	{
		
	}
	
	public List<Grade> getAllUserGrades(int userId){
		
		List<Grade> grades = new ArrayList<Grade>();
		
		RelationshipController relCon = new RelationshipController();
		
		List<Relationship> rels = relCon.findRelationships("user", userId, "grade");
		
		for(Relationship rel : rels){
			grades.add(getGradeFromId(rel.getTargetId()));
		}
		
		return grades;
		
	}
	
	public Grade getGradeFromId(int id){
		return DatabaseProvider.getInstance().getGradeById(id);
	}
	
}
