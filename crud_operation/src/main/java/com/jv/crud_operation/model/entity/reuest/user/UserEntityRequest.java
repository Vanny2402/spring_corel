package com.jv.crud_operation.model.entity.reuest.user;

import com.jv.crud_operation.model.entity.AddressEntity;
import com.jv.crud_operation.model.entity.UserEntity;

public class UserEntityRequest {

	
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

	public UserEntity toEntity() {
		UserEntity userEntity=new UserEntity();
		
		userEntity.setUsername(this.getUsername());
		userEntity.setAddress(this.getAddress());
		
		return userEntity;
	}
	
}
