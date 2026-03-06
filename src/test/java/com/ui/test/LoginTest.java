package com.ui.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pojo.User;

@Listeners({ com.ui.Listener.TestListener.class })
public class LoginTest extends TestBase {

	@Test(description = "Verifies whether valid user is able to login into the application", groups = { "e2e",
			"sanity" }, dataProviderClass = com.ui.dataProvider.LoginDataProvider.class, dataProvider = "LoginTestDataProvider", retryAnalyzer = com.ui.Listener.MyRetryAnalyzer.class)
	public void loginTest(User user) {

		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
				"Geo wrikch");
	}
//
//	@Test(description = "Verifies whether valid user is able to login into the application", groups = { "e2e",
//			"sanity" }, dataProviderClass = com.ui.dataProvider.LoginDataProvider.class, dataProvider = "LoginCSVTestDataProvider")
//	public void loginCSVTest(User user) {
//
//		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
//				"Geo wrikch");
//	}
//
//	@Test(description = "Verifies whether valid user is able to login into the application", groups = { "e2e",
//			"sanity" }, dataProviderClass = com.ui.dataProvider.LoginDataProvider.class, dataProvider = "LoginExcelTestDataProvider", retryAnalyzer = com.ui.Listener.MyRetryAnalyzer.class)
//	public void loginExcelTest(User user) {
//
//		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),
//				"Geo wrikch");
//
//	}

}