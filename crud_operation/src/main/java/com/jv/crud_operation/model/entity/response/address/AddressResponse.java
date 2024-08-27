package com.jv.crud_operation.model.entity.response.address;

import com.jv.crud_operation.model.entity.response.infra.BaseResponse;

public class AddressResponse extends BaseResponse {

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
