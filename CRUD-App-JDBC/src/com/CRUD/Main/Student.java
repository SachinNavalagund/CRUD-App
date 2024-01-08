package com.CRUD.Main;

public class Student 
{
	private String name;

	public String getName() 
	{
		return name;
	}
	protected void setName(String name)
	{
		this.name= name;
	}


	public static void main(String[] args) 
	{
		Student s1= new Student();
		s1.setName("Jack"); //Line2
		System.out.println(s1.getName());
	}
}
