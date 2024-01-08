package com.CRUD.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection 
{
	public static Connection connection;
	public static Connection getConnection()
	{
		try
		{
			connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/std", "root", "root123");
			System.out.println("Connection Established...");
			return connection;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;

	}

	public static void main(String[] args)
	{
		getConnection();
	}
}
