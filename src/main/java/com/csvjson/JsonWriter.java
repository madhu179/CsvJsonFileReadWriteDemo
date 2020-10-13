package com.csvjson;

import java.io.*;
import java.util.*;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonWriter {
	private static final String CSV_FILE_PATH = "C:\\Users\\MADHUBABU\\eclipse-workspace\\csvjson\\src\\main\\java\\com\\csvjson\\userdataheader.csv";
	private static final String JSON_FILE_PATH = "C:\\Users\\MADHUBABU\\eclipse-workspace\\csvjson\\src\\main\\java\\com\\csvjson\\userdata.json";

	public static void main(String[] args) throws IOException {

		Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));

		CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder(reader).withType(CSVUser.class)
				.withIgnoreLeadingWhiteSpace(true).build();

		List<CSVUser> csvUsers = csvToBean.parse();

		Gson gson = new Gson();
		String jsonString = gson.toJson(csvUsers);
		FileWriter writer = new FileWriter(JSON_FILE_PATH);
		writer.write(jsonString);
		writer.close();
		BufferedReader buffRead = new BufferedReader(new FileReader(JSON_FILE_PATH));
		CSVUser[] userObject = gson.fromJson(buffRead, CSVUser[].class);
		List<CSVUser> csvUserData = Arrays.asList(userObject);
		
		for(CSVUser csvUser : csvUserData)
		{
			System.out.println("Name = " + csvUser.getName() + ", Phone Number = " + csvUser.getPhno() + ", Country = " + csvUser.getCountry());
		}
	}
}
