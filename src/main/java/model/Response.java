package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties( { "newAddress" })
public class Response {

	private Address address;
	private boolean isNewAddress;
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

	

		
}
