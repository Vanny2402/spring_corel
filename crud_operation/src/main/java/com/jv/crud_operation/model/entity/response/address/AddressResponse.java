package com.jv.crud_operation.model.entity.response.address;

import java.io.Serializable;

public class AddressResponse implements Serializable {

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	private String address;
	
	public AddressResponse(String address) {
		this.address = address;
	}

}
