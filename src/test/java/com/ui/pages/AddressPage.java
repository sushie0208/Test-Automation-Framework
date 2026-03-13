package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.pojo.AddressPOJO;
import com.utility.BrowserUtility;

public class AddressPage extends BrowserUtility {

	private static final By ADDRESS_PAGE_TITLE = By.xpath("//h1[@class=\"page-subheading\"]");
	private static final By  COMPANY_TEXT_BOX_LOCATOR =By.id("company");
	private static final By  ADDRESS1_TEXT_BOX_LOCATOR =By.id("address1");
	private static final By  ADDRESS2_TEXT_BOX_LOCATOR =By.id("address2");
	private static final By  CITY_TEXT_BOX_LOCATOR =By.id("city");
	private static final By  POSTAL_CODE_TEXT_BOX_LOCATOR =By.id("postcode");
	private static final By  HOME_PHONE_TEXT_BOX_LOCATOR =By.id("phone");
	private static final By  MOBILE_PHONE_TEXT_BOX_LOCATOR =By.id("phone_mobile");
	private static final By  ADDRESS_ALIAS_TEXT_BOX_LOCATOR =By.id("alias");
	private static final By  SAVE_BUTTON_TEXT_BOX_LOCATOR =By.id("submitAddress");
	private static final By  ADDITIONAL_INFO_TEXT_AREA_LOCATOR =By.id("other");
	private static final By  STATE_DROPDOWN_LOCATOR =By.id("id_state");
	
	
	
	public AddressPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String getAddressPageTitle()
	{
		String title = getVisibleText(ADDRESS_PAGE_TITLE);
		return title;
	}
	
	public void saveAddress(AddressPOJO addressPOJO)
	{
		enterText(COMPANY_TEXT_BOX_LOCATOR, addressPOJO.getCompany());
		enterText(ADDRESS1_TEXT_BOX_LOCATOR,addressPOJO.getAddressLine1() );
		enterText(ADDRESS2_TEXT_BOX_LOCATOR, addressPOJO.getAddressLine2());
		enterText(CITY_TEXT_BOX_LOCATOR, addressPOJO.getCity());
		enterText(POSTAL_CODE_TEXT_BOX_LOCATOR, addressPOJO.getPostalCode());
		enterText(HOME_PHONE_TEXT_BOX_LOCATOR, addressPOJO.getHomePhone());
		enterText(MOBILE_PHONE_TEXT_BOX_LOCATOR, addressPOJO.getMobilePhone());
		enterText(ADDITIONAL_INFO_TEXT_AREA_LOCATOR, addressPOJO.getAdditionalInformation());
		clearText(ADDRESS_ALIAS_TEXT_BOX_LOCATOR);
		enterText(ADDRESS_ALIAS_TEXT_BOX_LOCATOR, addressPOJO.getAddressTitle());
		selectFromDropdown(STATE_DROPDOWN_LOCATOR, addressPOJO.getState());
		clickOn(SAVE_BUTTON_TEXT_BOX_LOCATOR);
	}

}
