package com.example.customer.details;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CustomerDetailsApplication
{

  public static void main(String[] args)
  {
    SpringApplication.run(CustomerDetailsApplication.class, args);
  }

}
