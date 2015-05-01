package com.YCPCS.Whiteboard.Controller;

import java.util.ArrayList;
import java.util.List;

import com.YCPCS.Whiteboard.Database.DatabaseProvider;
import com.YCPCS.Whiteboard.Model.Lecture;
import com.YCPCS.Whiteboard.Model.Relationship;

public class LectureController {
	
	public LectureController(){
		
	}
	
	public List<Lecture> getAllUserLectures(int userId){
		
		List<Relationship> rels = DatabaseProvider.getInstance().getTarget("user", "lecture", userId);
		
		List<Lecture> lectures = new ArrayList<Lecture>();
		if(rels != null){
			for(Relationship rel : rels){
				lectures.add(getLectureFromId(rel.getTargetId()));
			}
		}
		return lectures;
	}
	
	public Lecture getLectureFromId(int id){
		return DatabaseProvider.getInstance().getClassById(id);
	}
	
}
