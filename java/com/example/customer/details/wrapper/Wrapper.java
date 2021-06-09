package com.example.customer.details.wrapper;

import com.example.customer.details.model.CustomerDetails;

public class Wrapper {
	private CustomerDetails customerDetails;
	
private CustomerBasics customerBasics;

public Wrapper(CustomerDetails customerDetails, CustomerBasics customerBasics) {
	super();
	this.customerDetails = customerDetails;
	this.customerBasics = customerBasics;
}

public Wrapper() {
	super();
}

public CustomerDetails getCustomerDetails() {
	return customerDetails;
}

public void setCustomerDetails(CustomerDetails customerDetails) {
	this.customerDetails = customerDetails;
}

public CustomerBasics getCustomerBasics() {
	return customerBasics;
}

public void setCustomerBasics(CustomerBasics customerBasics) {
	this.customerBasics = customerBasics;
}

}
