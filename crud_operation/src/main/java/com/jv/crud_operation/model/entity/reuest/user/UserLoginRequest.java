package com.jv.crud_operation.model.entity.reuest.user;

import java.io.Serializable;

public class UserLoginRequest implements Serializable {

	private String username;

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
