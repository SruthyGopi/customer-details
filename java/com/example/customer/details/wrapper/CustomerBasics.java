package com.example.customer.details.wrapper;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
/*
 * @AllArgsConstructor
 * 
 * @NoArgsConstructor
 */

public class CustomerBasics {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Long customerId;
	private String firstName;
	private String surName;
	private String dateOfBirth;
	public CustomerBasics(Long customerId, String firstName, String surName, String dateOfBirth) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.surName = surName;
		this.dateOfBirth = dateOfBirth;
	}
	public CustomerBasics() {
		super();
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	

}
