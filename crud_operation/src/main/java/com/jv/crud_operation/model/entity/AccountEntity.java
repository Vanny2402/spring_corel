package com.jv.crud_operation.model.entity;

import com.jv.crud_operation.model.entity.response.infra.BaseSoftDeleteEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="accounts")
public class AccountEntity extends BaseSoftDeleteEntity<Long>{	
	
	@Column(length = 15,nullable = false,unique = true)
	private String name;
	
	@Column(nullable =  false)
	private Double balance;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

}
