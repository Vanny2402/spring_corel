package com.jv.crud_operation.model.entity.reuest.account;

import java.io.Serializable;

import com.jv.crud_operation.model.entity.AccountEntity;

public class AccountRequest implements Serializable {

	private Double balance;
	private String name;
	
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}


	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AccountEntity toEntity() {
		
		AccountEntity account=new AccountEntity();
		account.setBalance(this.balance);
		account.setName(this.name);
		return account;
	}
}
