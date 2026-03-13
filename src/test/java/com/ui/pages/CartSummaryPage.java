package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class CartSummaryPage extends BrowserUtility{

	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.xpath("//p[contains (@class ,\"cart_navigation\")]/a[@title=\"Proceed to checkout\"]/span");
	
	public CartSummaryPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public ConfirmAddressPage goToConfirmAddressPage()
	{
		clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		ConfirmAddressPage confirmAddressPage = new ConfirmAddressPage(getDriver());
		return confirmAddressPage;
	}

}
