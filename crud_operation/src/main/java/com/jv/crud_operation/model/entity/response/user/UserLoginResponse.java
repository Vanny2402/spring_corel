package com.jv.crud_operation.model.entity.response.user;

import java.io.Serializable;

import com.jv.crud_operation.model.entity.UserEntity;

public class UserLoginResponse implements Serializable{
	
	private Long id;
	private String username;	
	public UserLoginResponse(Long id, String username) {

		this.id=id;
		this.username=username;

	}
	public Long getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}

	public static UserLoginResponse fromEntity(UserEntity entity) {
		return new UserLoginResponse(entity.getId(),entity.getUsername());
	}
}
