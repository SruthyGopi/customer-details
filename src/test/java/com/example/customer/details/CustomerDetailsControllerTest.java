package com.example.customer.details;


import com.example.customer.details.model.CustomerDetails;
import com.example.customer.details.repository.CustomerDetailsRepository;
import com.example.customer.details.service.CustomerDetailsService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
class CustomerDetailsControllerTest
{

  @Autowired
  private MockMvc mockMvc;

  @Mock
  private CustomerDetailsRepository repository;

  @MockBean
  private CustomerDetailsService service;




  @Test
  void getCustomerById()throws Exception
  {
    String getExpected = "{\"customerId\":1,\"address\":\"IND\",\"phoneNo\":\"987666\",\"email\":\"sruthy@gmail.com\"}";
    CustomerDetails customerDetails=new CustomerDetails();
    customerDetails.setCustomerId(1L);
    customerDetails.setAddress("IND");
    customerDetails.setPhoneNo("987666");
    customerDetails.setEmail("sruthy@gmail.com");
    service.saveCustomerDetails(customerDetails);
    Mockito.when(service.getCustomerById(Mockito.anyLong())).thenReturn(customerDetails);
    RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
            "/customerdetails/1").accept(
            MediaType.APPLICATION_JSON);
    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    System.out.println(result.getResponse());
    JSONAssert.assertEquals(getExpected, result.getResponse()
            .getContentAsString(), false);


  }

  @Test
  void saveCustomerDetails()throws Exception
  {
    String postJsonBody = "{\"address\":\"IND\",\"phoneNo\":\"987666\",\"email\":\"sruthy@gmail.com\"}";
    CustomerDetails customerDetails=new CustomerDetails();
    customerDetails.setCustomerId(1L);
    customerDetails.setAddress("IND");
    customerDetails.setPhoneNo("987666");
    customerDetails.setEmail("sruthy@gmail.com");
    service.saveCustomerDetails(customerDetails);

    Mockito.when(service.saveCustomerDetails(Mockito.any(CustomerDetails.class))).thenReturn(customerDetails);
    RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
            "/customerdetails/add").accept(
            MediaType.APPLICATION_JSON).content(postJsonBody).contentType(MediaType.APPLICATION_JSON);
    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    MockHttpServletResponse response = result.getResponse();
    assertEquals(HttpStatus.CREATED.value(), response.getStatus());




  }

  @Test
  void updateCustomerDetails()throws Exception
  {
    String putJsonBody = "{\"customerId\":1,\"address\":\"IND\",\"phoneNo\":\"987666\",\"email\":\"sruthy@gmail.com\"}";
    CustomerDetails customerDetails=new CustomerDetails();
    customerDetails.setCustomerId(1L);
    customerDetails.setAddress("IND");
    customerDetails.setPhoneNo("987666");
    customerDetails.setEmail("sruthy@gmail.com");
    service.saveCustomerDetails(customerDetails);
    Mockito.when(service.updateCustomerDetails(Mockito.any(CustomerDetails.class))).thenReturn(customerDetails);
    RequestBuilder requestBuilder = MockMvcRequestBuilders.put(
            "/customerdetails/update").accept(
            MediaType.APPLICATION_JSON).content(putJsonBody).contentType(MediaType.APPLICATION_JSON);
    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    MockHttpServletResponse response = result.getResponse();
    assertEquals(HttpStatus.CREATED.value(), response.getStatus());

  }

  @Test
  void deleteCustomerDetails()throws Exception
  {
    service.deleteCustomerDetails(1L);
    assertEquals(false, repository.existsById(1L));
  }

  @Test
  void getAllCustomersDetails()throws Exception
  {
    List<CustomerDetails> customerBasics = service.getAllCustomerDetails();
    assertEquals(false, customerBasics.size()>0);
  }
}