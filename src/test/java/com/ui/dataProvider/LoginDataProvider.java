package com.ui.dataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.opencsv.CSVReader;
import com.ui.pojo.TestData;
import com.ui.pojo.User;
import com.utility.CSVReaderUtility;
import com.utility.ExcelReaderUtility;

public class LoginDataProvider {
	/*loginDataProvider() does NOT need parameters.
	Because TestNG calls it internally.
	You don’t call it.
	TestNG calls it.
	When TestNG sees this:

	@Test(dataProvider = "loginDataProvider")
	public void loginTest(User user)

	It does this behind the scenes:

	1️⃣ Look for a method named loginDataProvider
	2️⃣ Execute that method
	3️⃣ Get its return value (Iterator<Object[]>)
	4️⃣ For each Object[] returned:

	Call loginTest()

	Inject values from Object[] into method parameters*
	LoginDataProvider is only responsible for:
👉 Providing test data */
	@DataProvider(name = "LoginTestDataProvider")
	public Iterator<Object[]> loginDataProvider() {
		Gson gson = new Gson();
		File testDataFile = new File(System.getProperty("user.dir") + "//testData//loginData.json");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(testDataFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TestData data = gson.fromJson(fileReader, TestData.class);

		List<Object[]> dataToReturn = new ArrayList<Object[]>(); // dataprovider returns data in object array format
		for (User user : data.getData()) {
			/*
			 * 👉 Take ONE User at a time from the list data has 👉 Temporarily store it in
			 * variable user
			 */
			dataToReturn.add(new Object[] { user });
			/*
			 * That user is placed inside Object[].
			 * TestNG reads it. Matches it to method parameter in Login Test and Injects it into
			 * loginTest(User user).
			 */
		}

		/*
		 * Data provider methods can return data in object[] single dimensional Array ,
		 * Object[][]multi dimensional array and in iterator format if no name is given
		 * to the data provider annotation then it takes the method name as name of data
		 * provider but it is not a good practice
		 */
		return dataToReturn.iterator();
	}
	@DataProvider(name = "LoginCSVTestDataProvider")
	public Iterator<User> csvDataProvider()
	{
		return CSVReaderUtility.readCSVFile();
		
	}
	
	@DataProvider(name = "LoginExcelTestDataProvider")
	public Iterator<User> ExcelDataProvider()
	{
		return ExcelReaderUtility.readExcelFile();
		
	}
}
