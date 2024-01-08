package com.CRUD.Main;

import java.util.Scanner;

import com.CRUD.Controller.IStudentController;
import com.CRUD.Factory.StudentControllerFactory;
import com.CRUD.Pojo.Student;



public class MainApp 
{
	public static void main(String[] args)
	{
		Scanner scanner=null;
		String  name,age,id=null;
		IStudentController studentController=null;
		String status=null;
		Student stdRecord =null;

		while(true)
		{
			System.out.println("Welcome to our Application");
			System.out.println("1. CREATE");
			System.out.println("2. READ");
			System.out.println("3. UPDATE");
			System.out.println("4. DELETE");
			System.out.print("Plz enter ur choice : ");
			scanner=new Scanner(System.in); 
			int option=scanner.nextInt();

			switch(option) 
			{
			case 1:
				//collecting the input
				System.out.print("Enter the name :");
				name=scanner.next();
				System.out.print("Enter the age :");
				age=scanner.next();

				//sending the data to the controller using pojo
				Student student=new Student();
				student.setSname(name);
				student.setSage(Integer.parseInt(age));


				//pure abstraction
				studentController=StudentControllerFactory.getController();
				//invoke the controller
				status=studentController.save(student);
				System.out.println(status);

				break;

			case 2:
				//collecting the input
				System.out.print("Enter the id :");
				id=scanner.next();

				//pure abstraction
				studentController=StudentControllerFactory.getController();
				//invoke the controller
				stdRecord=studentController.getById(Integer.parseInt(id));

				if(stdRecord!=null) 
				{
					System.out.print(stdRecord);
				}
				else
				{
					System.out.print("Record not available for the given id :"+id); 
				}
				System.out.println(stdRecord);

				break;

			case 3:
				System.out.print("Enter the id :");
				id=scanner.next();

				//pure abstraction
				studentController=StudentControllerFactory.getController();
				//invoke the controller
				stdRecord=studentController.getById(Integer.parseInt(id));

				if(stdRecord!=null) 
				{
					//collecting input for update
					System.out.print("Old name is : " + stdRecord.getSname()+",  Enter the newName : ") ;
					String newName = scanner.next();

					System.out.print("Old age is : " + stdRecord.getSage()+",   Enter the newAge : ") ;
					String newAge=scanner.nextLine();

					Student newStudent=new Student();

					newStudent.setSid(stdRecord.getSid());

					//performing validation

					//name validation
					if(newName.equals("") || newName==null)
					{
						newStudent.setSname(stdRecord.getSname());
					}
					else
					{
						newStudent.setSname(newName);
					}

					//age validation
					if(newAge.equals("") || newAge==null)
					{
						newStudent.setSage(stdRecord.getSage());
					}
					else
					{
						newStudent.setSage(Integer.parseInt(newName));
					}

					status=studentController.updateById(newStudent);
					System.out.println(status);
				}
				else
				{
					System.out.print("Record not available for the updation :"+id); 
				}
				System.out.println(stdRecord);

				break;

			case 4:

				//collecting the input
				System.out.print("Enter the id :");
				id=scanner.next();

				//pure abstraction
				studentController=StudentControllerFactory.getController();
				//invoke the controller
				status =studentController.deleteById(Integer.parseInt(id));

				System.out.println(status);
				break;

			default:
				System.out.print(" Thanks for using application...");
				System.exit(0);

			}

		}
	}
}
