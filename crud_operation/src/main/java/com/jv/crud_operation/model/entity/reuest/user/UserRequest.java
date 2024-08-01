package com.jv.crud_operation.model.entity.reuest.user;

import java.io.Serializable;

import com.jv.crud_operation.model.entity.UserEntity;
import com.jv.crud_operation.model.entity.reuest.address.AddressEntityRequest;

public class UserRequest implements Serializable {

	private String username;
	private AddressEntityRequest address;

	
	public AddressEntityRequest getAddress() {
		return address;
	}
	public void setAddress(AddressEntityRequest address) {
		this.address = address;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	
	public UserEntity toEntity(UserEntity u) {
		UserEntity user=new UserEntity();
		user.setUsername(this.username);
		user.setAddress(u.getAddress());
		return user;
	}
}
