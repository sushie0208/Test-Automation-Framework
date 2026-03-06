package com.ui.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.BrowserUtility;

public class LoginTestOLD {

	public static void main(String[] args) {

		WebDriver wd = new ChromeDriver();
		
		BrowserUtility browserUtility = new BrowserUtility(wd);
		browserUtility.goToWebsite();
		browserUtility.manageWindow();
		
		By signInLinkLocator = ;
		browserUtility.clickOn(signInLinkLocator);
		
		
		By emailIdLocator = By.id("email");
		browserUtility.enterText(emailIdLocator, "gejowip815@provko.com");
	
		
		By passwordLocator = By.id("passwd");
		browserUtility.enterText(passwordLocator, "Password");
		
		
		By SignInButtonLocator = By.id("SubmitLogin");
		browserUtility.clickOn(SignInButtonLocator);

	}

}
