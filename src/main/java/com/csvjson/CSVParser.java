package com.csvjson;

import java.io.*;
import java.util.*;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.nio.file.Files;
import java.nio.file.Paths;

public class CSVParser {
	
	private static final String FILE_PATH = "C:\\Users\\MADHUBABU\\eclipse-workspace\\csvjson\\src\\main\\java\\com\\csvjson\\userdataheader.csv";

	public static void main(String[] args) throws IOException{
	
		Reader reader = Files.newBufferedReader(Paths.get(FILE_PATH));
	    
		CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder(reader).withType(CSVUser.class).withIgnoreLeadingWhiteSpace(true).build();
		
		Iterator<CSVUser> itr = csvToBean.iterator();
		
		while(itr.hasNext())
		{
			CSVUser csvUser = itr.next();
			System.out.println("Name = " + csvUser.getName() + ", Phone Number = " + csvUser.getPhno() + ", Country = " + csvUser.getCountry());
		}
		
		List<CSVUser> csvUsers = csvToBean.parse();
		
		for(CSVUser csvUser : csvUsers)
		{
			System.out.println("Name = " + csvUser.getName() + ", Phone Number = " + csvUser.getPhno() + ", Country = " + csvUser.getCountry());
		}
	}
}
