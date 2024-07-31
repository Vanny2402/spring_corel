package com.jv.crud_operation.model.entity.response;

import com.jv.crud_operation.model.entity.AddressEntity;
import com.jv.crud_operation.model.entity.UserEntity;

public class UserEntityResponse {
	
	private String username;
	private AddressEntity address;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public AddressEntity getAddress() {
		return address;
	}
	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	public UserEntityResponse fromEntity() {
		UserEntity userEntity=new UserEntity();
		
		return null;
	}
	
}
