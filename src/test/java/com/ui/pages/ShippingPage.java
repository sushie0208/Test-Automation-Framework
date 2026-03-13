package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShippingPage extends BrowserUtility {

	private static final By CHECKBOX_BUTTON_LOCATOR = By.id("uniform-cgv");
	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.xpath("//button[@name=\"processCarrier\"]/span");

	public ShippingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public PaymentPage goToPaymentPage() {

		clickOnCheckbox(CHECKBOX_BUTTON_LOCATOR);
		clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		PaymentPage paymentPage = new PaymentPage(getDriver());
		return paymentPage;
	}

}
