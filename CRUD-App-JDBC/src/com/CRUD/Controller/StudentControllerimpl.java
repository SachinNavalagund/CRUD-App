package com.CRUD.Controller;

import com.CRUD.Factory.StudentServiceFactory;
import com.CRUD.Pojo.Student;
import com.CRUD.Service.IStudentService;

public class StudentControllerimpl implements IStudentController
{
	@Override
	public String save(Student student) 
	{
		IStudentService studentService =StudentServiceFactory.getService();
		return studentService.save(student);
	}

	@Override
	public Student getById(int id) 
	{
		IStudentService studentService =StudentServiceFactory.getService(); 

		return studentService.getById(id);
	}

	@Override
	public String updateById(Student student) 
	{
		IStudentService studentService =StudentServiceFactory.getService();
		return studentService.updateById(student);
	}

	@Override
	public String deleteById(int id) 
	{
		IStudentService studentService =StudentServiceFactory.getService();
		return studentService.deleteById(id);
	}
}
