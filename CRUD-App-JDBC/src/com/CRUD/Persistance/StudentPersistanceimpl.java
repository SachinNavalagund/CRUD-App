package com.CRUD.Persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.CRUD.Connection.GetConnection;
import com.CRUD.Pojo.Student;


public class StudentPersistanceimpl implements IStudentPersistance
{
	@Override
	public String save(Student student)
	{
		Connection connection=null;
		PreparedStatement pstmt=null; 
		try 
		{
			connection=GetConnection.getConnection();

			if(connection!=null)
			{
				String SQL_INSERT_QUERY="INSERT INTO STUDENT(SNAME,SAGE) VALUES(?,?)";
				pstmt=connection.prepareStatement(SQL_INSERT_QUERY);

				if (pstmt != null )
				{
					pstmt.setString(1, student.getSname());
					pstmt.setInt(2, student.getSage());

					int rowCount=pstmt.executeUpdate();
					if(rowCount>0)
					{
						return "record inserted succesfully..";
					}

					return "record inserted failed try again...";

				}
			}
		}
		catch (SQLException  e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return "record inserted failed try again...";

	}
	@Override
	public Student getById(int id)
	{
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement pstmt=null; 
		ResultSet resultSet=null;
		try 
		{
			connection=GetConnection.getConnection();

			if(connection!=null)
			{
				String SQL_SELECT_QUERY="SELECT SID,SNAME,SAGE FROM STUDENT WHERE SID=?";
				pstmt=connection.prepareStatement(SQL_SELECT_QUERY);

				if (pstmt != null )
				{
					pstmt.setInt(1, id);
					resultSet=pstmt.executeQuery(); 
				}
				if(resultSet.next())
				{
					Student student=new Student();
					student.setSid(id);
					student.setSname(resultSet.getString(2));
					student.setSage(resultSet.getInt(3));

					return student;
				}

			}
		}
		catch (SQLException  e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public String updateById(Student student)
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		try 
		{
			connection=GetConnection.getConnection();

			if(connection!=null)
			{
				String SQL_UPDATE_QUERY="UPDATE STUDENT SET SNAME=?,SAGE=? WHERE SID=?";
				pstmt=connection.prepareStatement(SQL_UPDATE_QUERY);

				if (pstmt != null )
				{
					pstmt.setString(1, student.getSname());
					pstmt.setInt(2, student.getSage());
					pstmt.setInt(3, student.getSid());

					pstmt.getUpdateCount(); 
					return "Update successfully....";
				}

			}
		}
		catch (SQLException  e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return "Update failed";
	}

	@Override
	public String deleteById(int id) 
	{
		if(getById(id)==null)
		{
			return "Record not available for deleting the record with the id:"+id;
		}
		else
		{
			Connection connection=null;
			PreparedStatement pstmt=null;

			try 
			{
				connection=GetConnection.getConnection();

				if(connection!=null)
				{
					String SQL_DELETE_QUERY="DELETE FROM STUDENT WHERE SID=?";
					pstmt=connection.prepareStatement(SQL_DELETE_QUERY);

					if (pstmt != null )
					{
						pstmt.setInt(1, id);
						pstmt.executeUpdate();

					}  
				}
			}
			catch (SQLException  e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return "Record deleted successfully"+id;


	}
}
