package com.example.customer.details.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.customer.details.model.CustomerDetails;
import com.example.customer.details.repository.CustomerDetailsRepository;
import com.example.customer.details.wrapper.CustomerBasics;
import com.example.customer.details.wrapper.Wrapper;

@Service
public class CustomerDetailsService {
	
	@Autowired
	private CustomerDetailsRepository customerBasicsRepository;

	@Autowired
	private RestTemplate restTemplate;

	public CustomerDetails saveCustomerDetails(CustomerDetails customerDetails) {
		// TODO Auto-generated method stub
		return customerBasicsRepository.save(customerDetails);
	}
	public Wrapper getAllCustomerInfo(Long customerId) {
		Wrapper wrapper = new Wrapper();
		CustomerDetails customerDetails = customerBasicsRepository.findById (customerId).get();
		CustomerBasics customerBasics =restTemplate.getForObject("http://localhost:8090/customerbasics/"
		+customerDetails.getCustomerId(),
				CustomerBasics.class);
				wrapper.setCustomerBasics(customerBasics);
		wrapper.setCustomerDetails(customerDetails);
				return wrapper;
		
	}

}
