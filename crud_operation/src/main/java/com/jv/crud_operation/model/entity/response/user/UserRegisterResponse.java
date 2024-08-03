package com.jv.crud_operation.model.entity.response.user;

import java.io.Serializable;

import com.jv.crud_operation.model.entity.UserEntity;
import com.jv.crud_operation.model.entity.response.address.AddressResponse;

public class UserRegisterResponse implements Serializable{
	
	private Long id;
	private String username;
	private AddressResponse address;
	
	public UserRegisterResponse(Long id, String username, AddressResponse address) {

		this.id=id;
		this.username=username;
		this.address=address;
	}
	public Long getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public AddressResponse getAddress() {
		return address;
	}

	public static UserRegisterResponse fromEntity(UserEntity entity) {
		AddressResponse addr=new AddressResponse(entity.getAddress().getAddress());
		return new UserRegisterResponse(entity.getId(),entity.getUsername(),addr);
	}
}
