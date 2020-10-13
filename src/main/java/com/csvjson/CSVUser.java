package com.csvjson;

import com.opencsv.bean.CsvBindByName;

public class CSVUser {
	
	@CsvBindByName
	private String name;
	
	@CsvBindByName
	private String phno;
	
	@CsvBindByName
	private String country;
	
	public CSVUser()
	{
		
	}
	
	public CSVUser(String name, String phno, String country) {
		super();
		this.name = name;
		this.phno = phno;
		this.country = country;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		return "CSVUser{name='"+name+'\''+", phnoeNo='"+phno+'\''+", country='"+country+'\''+"}";
	}
	

}
