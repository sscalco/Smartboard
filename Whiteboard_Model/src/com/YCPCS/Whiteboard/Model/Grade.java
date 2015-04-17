package com.YCPCS.Whiteboard.Model;

import java.util.ArrayList;

public class Grade 
{
	private String gradeLetter;
	private double grade = 0;
	private ArrayList<Double> gradeParams = new ArrayList<Double>();
	private ArrayList<String> gradeLetters = new ArrayList<String>();
	public Grade()
	{
		//Initial grades Params
		gradeParams.add(59.4);
		gradeParams.add(69.4);
		gradeParams.add(79.4);
		gradeParams.add(89.4);
		gradeParams.add(100.0);
		gradeLetters.add("F");
		gradeLetters.add("D");
		gradeLetters.add("C");
		gradeLetters.add("B");
		gradeLetters.add("A");
		setGradeLetter();
	}
	public void setGrade(double grade)
	{
		this.grade = grade;
		setGradeLetter();
	}
	public void setGradeLetter()
	{
		for(int i = 0; i < gradeParams.size(); i++)
		{
			if(grade < gradeParams.get(i))
			{
				gradeLetter = gradeLetters.get(i);
				return;
			}
		}
	}
	public double getGrade()
	{
		return grade;
	}
	public String getLetter()
	{
		return gradeLetter;
	}
}
