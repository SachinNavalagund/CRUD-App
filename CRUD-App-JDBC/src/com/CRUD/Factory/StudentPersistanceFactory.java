package com.CRUD.Factory;

import com.CRUD.Persistance.IStudentPersistance;
import com.CRUD.Persistance.StudentPersistanceimpl;


public class StudentPersistanceFactory 
{
	private static StudentPersistanceimpl studentPersestanceimpl;

	static 
	{
		studentPersestanceimpl=new StudentPersistanceimpl();
	}

	public static IStudentPersistance getPersestance()
	{
		return studentPersestanceimpl;

	}
}
