package com.ui.Listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import com.constants.Env;
import com.utility.JsonUtility;
import com.utility.PropertiesUtil;

public class MyRetryAnalyzer implements IRetryAnalyzer {

	//private static int MAX_NUMBER_OF_ATTEMPTS=Integer.parseInt(PropertiesUtil.readProperty(Env.DEV, "MAX_NUMBER_OF_ATTEMPTS"));
	
	private final int MAX_NUMBER_OF_ATTEMPTS=JsonUtility.readJson().getMAX_NUMBER_OF_ATTEMPTS();
	private int currentAttempt=1;

	
	public boolean retry(ITestResult result) {
		if(currentAttempt<=MAX_NUMBER_OF_ATTEMPTS)
		{
			currentAttempt++;
			return true;		
		}
		return false;
	}

}
