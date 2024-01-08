package com.CRUD.Factory;

import com.CRUD.Controller.IStudentController;
import com.CRUD.Controller.StudentControllerimpl;

public class StudentControllerFactory 
{
	private static IStudentController studentController;

	static
	{
		studentController =new StudentControllerimpl();
	}

	public static IStudentController getController() 
	{
		return studentController;
	}
}
