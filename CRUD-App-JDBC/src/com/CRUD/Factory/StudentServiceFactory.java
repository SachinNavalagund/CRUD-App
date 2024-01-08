package com.CRUD.Factory;

import com.CRUD.Service.IStudentService;
import com.CRUD.Service.StudentServiceImpl;

public class StudentServiceFactory 
{
	private static StudentServiceImpl studentServiceImpl;

	static
	{
		studentServiceImpl=new StudentServiceImpl();
	}

	public static IStudentService getService() 
	{
		return studentServiceImpl;

	}
}
