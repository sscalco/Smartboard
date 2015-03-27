package com.YCPCS.Whiteboard.Controller;

import java.util.ArrayList;
import java.util.List;

import com.YCPCS.Whiteboard.Database.DatabaseProvider;
import com.YCPCS.Whiteboard.Model.Relationship;

public class RelationshipController {
	
	public RelationshipController(){
		
	}
	
	public List<Relationship> findRelationships(String root, int root_id, String target){
		
		List<Relationship> relList = new ArrayList<Relationship>();
		
		for(Relationship rel : DatabaseProvider.getInstance().getRelationshipsByRootAndTarget(root, target)){
			if(rel.getRootId()==root_id){
				relList.add(rel);
			}
		}
		
		return relList;	
	}
	
}
