package com.ui.test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.constants.Size;
import com.ui.pages.SearchResultPage;


public class ProductCheckoutTest extends TestBase{
	
	private static final String SEARCH_TERM="Printed Summer Dress";
	
	private SearchResultPage searchResultPage;
	
	@BeforeMethod(description = "User logs in and searched for a product ")
	public void setup()
	{
		searchResultPage = homePage.goToLoginPage().doLoginWith("gejowip815@provko.com", "Password").searchForAProduct(SEARCH_TERM);
	}
	
	@Test(description="verify if the logged in user is able to buy a dress",groups= {"e2e","smoke","sanity"})
	public void checkoutTest()
	{
	String result =searchResultPage.clickOnTheProductAt(1).changeSize(Size.L).addToCart().proceedToCheckout().goToConfirmAddressPage().goToShippingPage()
	.goToPaymentPage().verifyMessage();
	System.out.println(result);
	Assert.assertTrue(result.contains("installed"));
	}
}
