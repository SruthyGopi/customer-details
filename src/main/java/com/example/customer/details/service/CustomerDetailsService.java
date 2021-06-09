package com.example.customer.details.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customer.details.model.CustomerDetails;
import com.example.customer.details.repository.CustomerDetailsRepository;

import java.util.List;

@Service
public class CustomerDetailsService
{

  @Autowired
  private CustomerDetailsRepository customerDetailsRepository;

  public CustomerDetails saveCustomerDetails(CustomerDetails customerDetails)
  {
    return customerDetailsRepository.save(customerDetails);
  }

  public CustomerDetails getCustomerById(Long customerId)
  {
    return customerDetailsRepository.findById(customerId).get();
  }

  public CustomerDetails updateCustomerDetails(CustomerDetails customerDetails)
  {
    return customerDetailsRepository.save(customerDetails);
  }

  public void deleteCustomerDetails(Long customerId)
  {
    customerDetailsRepository.deleteById(customerId);
  }

  public List<CustomerDetails> getAllCustomerDetails()
  {
    return customerDetailsRepository.findAll();
  }

}
