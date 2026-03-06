package com.utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class CSVReaderUtility {
	public static Iterator<User> readCSVFile() {
		File csvFile = new File(System.getProperty("user.dir") + "//testData//loginData.csv");
		FileReader fileReader = null;
		String[] data;
		CSVReader csvReader;
		List<User> userList = null;
		User user;
		try {
			fileReader = new FileReader(csvFile);
			csvReader = new CSVReader(fileReader);
			userList = new ArrayList<User>();
			data = csvReader.readNext();
			while ((data = csvReader.readNext()) != null) {
				user = new User(data[0], data[1]);
				userList.add(user);
			}
		} catch (CsvValidationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userList.iterator();

	}

}
