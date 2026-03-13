package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Size;
import com.utility.BrowserUtility;

public class ProductDetailPage extends BrowserUtility{
	private static final By SIZE_DROP_DOWN_LOCATOR = By.id("group_1");
	private static final By ADD_TO_CART_BUTTON_LOCATOR = By.xpath("//button[@name=\"Submit\"]/span");
	private static final By PROCEED_TO_CHECKOUT_BUTON_LOCATOR = By.xpath("//a[@title=\"Proceed to checkout\"]/span");
	
	public ProductDetailPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	public ProductDetailPage changeSize(Size size)
	{
		selectFromDropdown(SIZE_DROP_DOWN_LOCATOR, size.toString());
		return new ProductDetailPage(getDriver());
	}
	
	public ProductDetailPage addToCart()
	{
		clickOn(ADD_TO_CART_BUTTON_LOCATOR);
		return new ProductDetailPage(getDriver());
	}
	
	public CartSummaryPage proceedToCheckout()
	{
	
		clickOn(PROCEED_TO_CHECKOUT_BUTON_LOCATOR);
		CartSummaryPage cartSummaryPage = new CartSummaryPage(getDriver());
		return cartSummaryPage;
		
	}

}
