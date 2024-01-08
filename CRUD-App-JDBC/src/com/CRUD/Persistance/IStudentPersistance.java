package com.CRUD.Persistance;

import com.CRUD.Pojo.Student;

public interface IStudentPersistance 
{
	public String save(Student student);

	public Student getById(int Id);

	public String updateById(Student student);

	public String deleteById(int Id);
}
