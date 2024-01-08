package com.CRUD.Service;

import com.CRUD.Factory.StudentPersistanceFactory;
import com.CRUD.Persistance.IStudentPersistance;
import com.CRUD.Pojo.Student;


public class StudentServiceImpl implements IStudentService
{
	@Override
	public String save(Student student)
	{
		IStudentPersistance persistance= StudentPersistanceFactory.getPersestance();
		return persistance.save(student);
	}

	@Override
	public Student getById(int id) 
	{
		IStudentPersistance persistance= StudentPersistanceFactory.getPersestance();

		return persistance.getById(id);
	}

	@Override
	public String updateById(Student student) 
	{
		IStudentPersistance persistance= StudentPersistanceFactory.getPersestance();
		return persistance.updateById(student);
	}

	@Override
	public String deleteById(int id) 
	{
		IStudentPersistance persistance= StudentPersistanceFactory.getPersestance();
		return persistance.deleteById(id);
	}
}
