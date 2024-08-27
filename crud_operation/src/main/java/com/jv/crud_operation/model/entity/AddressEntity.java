package com.jv.crud_operation.model.entity;

import com.jv.crud_operation.model.entity.response.infra.BaseAuditEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="address")
public class AddressEntity extends BaseAuditEntity<Long>{

	
	@Column(length = 100,nullable = false)
	private String address;
	
	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="userId",nullable = false,referencedColumnName = "id")
//	@MapsId
	private UserEntity user;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


}
