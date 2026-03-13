package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class PaymentPage extends BrowserUtility {

	private static final By ERROR_MESSAGE_LOCATOR = By.xpath("//div[@class=\"paiement_block\"]//p[contains(text(),'No payment modules have been installed.')]"); 
	
	public PaymentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String verifyMessage()
	{
		return getVisibleText(ERROR_MESSAGE_LOCATOR);
	}
}
