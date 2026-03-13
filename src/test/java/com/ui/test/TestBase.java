package com.ui.test;

import static com.constants.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.ExtentReportUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase {

	protected HomePage homePage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	WebDriver lambdaDriver;
	private boolean isLambdaTest;

	@Parameters({ "browser", "isLambdaTest", "isHeadless" })
	@BeforeMethod(description = "Loads HomePage Of Website")

	public void setup( ITestResult result,
			@Optional("chrome") String browser, 
			@Optional("false") boolean isLambdaTest, 
			@Optional("false") boolean isHeadless) {
		this.isLambdaTest = isLambdaTest;
		
		if (isLambdaTest) {
			lambdaDriver = LambdaTestUtility.initializeLamdaTestSession(browser, result.getMethod().getMethodName());
			homePage = new HomePage(lambdaDriver);
		} else {
			logger.info("Loads the Website");
			homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadless);
		}
	}

	public BrowserUtility getInstance() {
		return homePage;
	}
	@AfterMethod
	public void tearDown() {

		logger.info("Closing browser");
		if (isLambdaTest) {
			LambdaTestUtility.quitSession();
		} else {

			homePage.quit();
}
		
	}
}
