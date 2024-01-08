package com.CRUD.Controller;

import com.CRUD.Pojo.Student;

public interface IStudentController 
{
	public String save(Student student);

	public Student getById(int Id);

	public String updateById(Student student);

	public String deleteById(int Id);

}
