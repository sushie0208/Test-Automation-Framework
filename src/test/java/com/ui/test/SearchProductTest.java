package com.ui.test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;
import com.ui.pojo.User;

@Listeners({ com.ui.Listener.TestListener.class })
public class SearchProductTest extends TestBase {

	private static final String SEARCH_TERM="Printed Summer Dress";
	private MyAccountPage myAccountPage;
	
	@BeforeMethod(description="Valid user logs in th Application")
	@Test(description = "Verifies user logs into the application", groups = { "e2e",
			"sanity" })
	public void setup() {

		myAccountPage = homePage.goToLoginPage().doLoginWith("gejowip815@provko.com", "Password");
	}
	
@Test(description = "Verify if the Logged in User is able to verify the product",groups= {"e2e","smoke","sanity"})
	public void searchProductTest()
	{
		boolean actualResult = myAccountPage.searchForAProduct(SEARCH_TERM).isSearchTermPresentInProductList(SEARCH_TERM);
		Assert.assertEquals(actualResult, true);
	}

}