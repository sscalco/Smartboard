package com.YCPCS.Whiteboard.Model;

public class Permission {
	
	private int id;
	private String name;
	private int userId;
	private boolean fruitcake;
	
	public Permission() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean isFruitcake() {
		return fruitcake;
	}

	public void setFruitcake(boolean fruitcake) {
		this.fruitcake = fruitcake;
	}

}
