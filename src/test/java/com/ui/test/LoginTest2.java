package com.ui.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ui.pages.HomePage;

public class LoginTest2 {
	
	public static void main(String[]args)
	{
	
	WebDriver wd = new ChromeDriver();
	HomePage homePage = new HomePage(wd);
	homePage.goToLoginPage().doLoginWith("gejowip815@provko.com","Password").g ;

}
}