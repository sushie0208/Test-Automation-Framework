package com.ui.pojo;

public class AddressPOJO {
private String company ;
private String AddressLine1;
private String AddressLine2;
private String city;
private String state;
private String postalCode;
private String homePhone;
private String mobilePhone;
private String additionalInformation;
private String addressTitle;

public String getCompany() {
	return company;
}
public String getAddressLine1() {
	return AddressLine1;
}
public String getAddressLine2() {
	return AddressLine2;
}
public String getCity() {
	return city;
}
public String getState() {
	return state;
}
public String getPostalCode() {
	return postalCode;
}
public String getHomePhone() {
	return homePhone;
}
public String getMobilePhone() {
	return mobilePhone;
}
public String getAdditionalInformation() {
	return additionalInformation;
}
public String getAddressTitle() {
	return addressTitle;
}

public AddressPOJO(String company, String addressLine1, String addressLine2, String city, String state,
		String postalCode, String homePhone, String mobilePhone, String additionalInformation, String addressTitle) {
	super();
	this.company = company;
	AddressLine1 = addressLine1;
	AddressLine2 = addressLine2;
	this.city = city;
	this.state = state;
	this.postalCode = postalCode;
	this.homePhone = homePhone;
	this.mobilePhone = mobilePhone;
	this.additionalInformation = additionalInformation;
	this.addressTitle = addressTitle;
}
@Override
public String toString() {
	return "AddressPOJO [company=" + company + ", AddressLine1=" + AddressLine1 + ", AddressLine2=" + AddressLine2
			+ ", city=" + city + ", state=" + state + ", postalCode=" + postalCode + ", homePhone=" + homePhone
			+ ", mobilePhone=" + mobilePhone + ", additionalInformation=" + additionalInformation + ", addressTitle="
			+ addressTitle + "]";
}

}
