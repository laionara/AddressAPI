package com.github.addressapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties( { "newAddress" , "validCep" } )
public class Response {

	private Address address;
	private boolean isNewAddress;
	private boolean isValidCep;
	private String message;
	
	public Response(){
		
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isNewAddress() {
		return isNewAddress;
	}

	public void setNewAddress(boolean isNewAddress) {
		this.isNewAddress = isNewAddress;
	}

	public boolean isValidCep() {
		return isValidCep;
	}

	public void setValidCep(boolean isValidCep) {
		this.isValidCep = isValidCep;
	}
	

		
}
