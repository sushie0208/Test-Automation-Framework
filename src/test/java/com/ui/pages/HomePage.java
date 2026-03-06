package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.JsonUtility;
import com.utility.LoggerUtility;

import static com.utility.PropertiesUtil.*;

import java.time.Duration;

public final class HomePage extends BrowserUtility {
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private static final By SIGNINLINKLOCATOR =By.xpath("//a[contains(text(),\"Sign in\")]");

	public HomePage(Browser browserName,boolean isHeadless) {
		super(browserName, isHeadless);
		goToWebsite(JsonUtility.readJson().getUrl());
	}
	
	public HomePage(WebDriver driver) {
		super(driver);
		goToWebsite(JsonUtility.readJson().getUrl());
	}

	public LoginPage goToLoginPage() //PageFunctions
	{
		logger.info("Navigating to Login Page");
		 WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.elementToBeClickable(SIGNINLINKLOCATOR)).click();
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
		
	}
	

	

}
