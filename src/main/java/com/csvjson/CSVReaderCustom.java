package com.csvjson;

import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.opencsv.CSVReader;

public class CSVReaderCustom {

	private static final String FILE_PATH = "C:\\Users\\MADHUBABU\\eclipse-workspace\\csvjson\\src\\main\\java\\com\\csvjson\\userdata.csv";

	public static void main(String[] args) throws IOException {
		Reader reader = Files.newBufferedReader(Paths.get(FILE_PATH));
		CSVReader csvFileReader = new CSVReader(reader);

		String[] record;

		//Reading records one at a time
		while ((record = csvFileReader.readNext()) != null) {
			System.out.println("Name = " + record[0] + ", Phone Number = " + record[1] + "Country = " + record[2]);
		}
		
		//Reading all the records at a time
		List<String[]> records = csvFileReader.readAll();
		for(String[] newRecord : records)
		{
			System.out.println("Name = " + newRecord[0] + ", Phone Number = " + newRecord[1] + "Country = " + newRecord[2]);
		}
	}

}
