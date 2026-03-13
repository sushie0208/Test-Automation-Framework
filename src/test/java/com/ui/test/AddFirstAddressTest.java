package com.ui.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;
import com.utility.FakeAddressUtility;

public class AddFirstAddressTest extends TestBase{
	MyAccountPage myAccountPage ;
	AddressPage addressPage;
	String name;
	private AddressPOJO addressPOJO;
	
	@BeforeMethod(description="Valid User is able to log in")
	public void setup() {

		 myAccountPage = homePage.goToLoginPage().doLoginWith("gejowip815@provko.com", "Password");
		 addressPOJO=FakeAddressUtility.getFakeAddress();
	}
	
@Test(description = "Verify if Logged In user is able to fill address information",groups= {"e2e","smoke","sanity"})
	public void addFirstAddress()
	{
	//name =myAccountPage.goToAddressPage().getAddressPageTitle();	
	//System.out.println(name);
	myAccountPage.goToAddressPage().saveAddress(addressPOJO);
	}

}
