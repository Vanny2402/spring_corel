package com.jv.crud_operation.model.entity.reuest.user;

import java.io.Serializable;

import com.jv.crud_operation.model.entity.UserEntity;
import com.jv.crud_operation.model.entity.reuest.address.AddressEntityRequest;

public class UserEntityRequuest implements Serializable {

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public AddressEntityRequest getAddress() {
		return address;
	}

	public void setAddress(AddressEntityRequest address) {
		this.address = address;
	}
	private String username;
	private AddressEntityRequest address;
	
	
	
	public UserEntity toEntity() {
		UserEntity user=new UserEntity();
		user.setUsername(this.username);
		
		return user; 
	}
	
}
