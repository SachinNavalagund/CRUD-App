package com.CRUD.Pojo;

public class Student 
{
	private Integer sid;
	private String sname;
	private Integer sage;

	public Student() 
	{
		System.out.println("Student Object is instantiated....");
	}

	public Integer getSid() 
	{
		return sid;
	}
	public void setSid(Integer sid) 
	{
		this.sid = sid;
	}

	public String getSname() 
	{
		return sname;
	}
	public void setSname(String sname) 
	{
		this.sname = sname;
	}

	public Integer getSage() 
	{
		return sage;
	}
	public void setSage(Integer sage) 
	{
		this.sage = sage;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sage=" + sage + "]";
	}


}
