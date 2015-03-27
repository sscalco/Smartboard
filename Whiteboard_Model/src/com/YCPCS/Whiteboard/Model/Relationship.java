package com.YCPCS.Whiteboard.Model;

public class Relationship {
	
	private int id;
	private String target, root;
	private int target_id, root_id;
	
	public Relationship(){
		
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
	public void setTarget(String target){
		this.target = target;
	}
	
	public void setTargetId(int id){
		this.target_id = id;
	}
	
	public void setRootId(int id){
		this.root_id = id;
	}
	
	public void setRoot(String root){
		this.root = root;
	}
	
	public String getTarget(){
		return target;
	}
	
	public String getRoot(){
		return root;
	}
	
	public int getRootId(){
		return root_id;
	}
	
	public int getTargetId(){
		return target_id;
	}

}
