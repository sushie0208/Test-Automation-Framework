package com.ui.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.ui.pojo.User;

public class InvalidCredentialsLoginTest extends TestBase{
	
	public static String INVALID_EMAIL_ID="geowrikch@gmail.com";
	public static String INVALID_PASSWORD="geowrikch";

	@Test(description = "Verifies whether Error Message is displayed for User logging with Invalid Crdentials", groups = { "e2e",
			"sanity" })
	public void loginTest() {

		assertEquals(homePage.goToLoginPage().doLoginWithInvalidCredentials(INVALID_EMAIL_ID, INVALID_PASSWORD).getErrorMessage(),"Authentication failed.");
	}

}
