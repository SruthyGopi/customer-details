package com.example.customer.details.controller;

import com.example.customer.details.handler.RecordNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.details.model.CustomerDetails;
import com.example.customer.details.service.CustomerDetailsService;

import java.util.List;

@RestController
@RequestMapping("/customerdetails")
@Api(value = "customerdetails", description = "Portal for adding Customer Details")
public class CustomerDetailsController {
	@Autowired
	private CustomerDetailsService customerDetailsService;

	@ApiOperation(value = "Get customer details", response = CustomerDetails.class, tags = " Get customer details")
	@GetMapping("/{id}")
	public ResponseEntity<CustomerDetails> getCustomerById(@PathVariable("id") Long customerId)
			throws RecordNotFoundException {
		return new ResponseEntity<>(customerDetailsService.getCustomerById(customerId), HttpStatus.OK);
	}

	@ApiOperation(value = "Add customer details", response = CustomerDetails.class, tags = " Add customer details")
	@PostMapping("/add")
	public ResponseEntity<CustomerDetails> saveCustomerDetails(@RequestBody CustomerDetails customerDetails)
			throws RecordNotFoundException {
		return new ResponseEntity<>(customerDetailsService.saveCustomerDetails(customerDetails), HttpStatus.CREATED);
	}

	@ApiOperation(value = "update customer details", response = CustomerDetails.class, tags = " Update customer details")
	@PutMapping("/update")
	public ResponseEntity<CustomerDetails> updateCustomerDetails(@RequestBody CustomerDetails customerDetails)
			throws RecordNotFoundException {
		return new ResponseEntity<>(customerDetailsService.updateCustomerDetails(customerDetails), HttpStatus.CREATED);
	}

	@ApiOperation(value = "delete customer details", response = CustomerDetails.class, tags = " Delete customer details")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCustomerDetails(@PathVariable(value = "id") Long id)
			throws RecordNotFoundException {
		customerDetailsService.deleteCustomerDetails(id);
		return new ResponseEntity<>("CustomerDetails with customerId : " + id + " deleted successfully", HttpStatus.OK);
	}

	@ApiOperation(value = "get all customer details", response = CustomerDetails.class, tags = " Get all customer details")
	@GetMapping("/all")
	public ResponseEntity<List<CustomerDetails>> getAllCustomersDetails() throws RecordNotFoundException {
		return new ResponseEntity<>(customerDetailsService.getAllCustomerDetails(), HttpStatus.OK);
	}

}
