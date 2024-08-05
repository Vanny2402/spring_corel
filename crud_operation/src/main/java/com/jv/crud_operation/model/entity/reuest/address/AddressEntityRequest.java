package com.jv.crud_operation.model.entity.reuest.address;

import java.io.Serializable;

import com.jv.crud_operation.model.entity.AddressEntity;
import com.jv.crud_operation.model.entity.UserEntity;

public class AddressEntityRequest implements Serializable{

	private String address;
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public AddressEntity toEntity(UserEntity parentEntity) {
		AddressEntity address=new AddressEntity();
		address.setAddress(this.getAddress());
		address.setUser(parentEntity);
		return address;
	}
}
