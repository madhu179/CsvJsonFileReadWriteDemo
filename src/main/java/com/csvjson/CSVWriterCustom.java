package com.csvjson;

import java.io.*;
import java.util.*;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.nio.file.Files;
import java.nio.file.Paths;

public class CSVWriterCustom {

	private static final String FILE_PATH = "C:\\Users\\MADHUBABU\\eclipse-workspace\\csvjson\\src\\main\\java\\com\\csvjson\\output.csv";

	public static void main(String[] args) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {

		FileWriter writer = new FileWriter(FILE_PATH);
		
		List<CSVUser> csvUsers = new ArrayList<CSVUser>();
		csvUsers.add(new CSVUser("Steve Rogers", "+87 9876567876", "USA"));
		csvUsers.add(new CSVUser("Peter Parker", "+84 3456789012", "USA"));
		
		StatefulBeanToCsvBuilder<CSVUser> builder = new StatefulBeanToCsvBuilder(writer).withQuotechar(CSVWriter.NO_QUOTE_CHARACTER);
		StatefulBeanToCsv beanWriter = builder.build();

		beanWriter.write(csvUsers);
		
		writer.close();

//    	Writer writer = Files.newBufferedWriter(Paths.get(FILE_PATH));  	
//    	StatefulBeanToCsv<CSVUser> beanToCSV = new StatefulBeanToCsvBuilder(writer).withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();
//			beanToCSV.write(csvUsers);


		Reader reader = Files.newBufferedReader(Paths.get(FILE_PATH));

		CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder(reader).withType(CSVUser.class)
				.withIgnoreLeadingWhiteSpace(true).build();

		List<CSVUser> csvUserss = csvToBean.parse();

		for (CSVUser csvUser : csvUserss) {
			System.out.println("Name = " + csvUser.getName() + ", Phone Number = " + csvUser.getPhno() + ", Country = "
					+ csvUser.getCountry());
		}
	}
}
