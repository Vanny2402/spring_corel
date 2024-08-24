package com.jv.crud_operation.model.entity.response.account;

import com.jv.crud_operation.model.entity.AccountEntity;
import com.jv.crud_operation.model.entity.response.infra.BaseResponse;

public class AccountResponse extends BaseResponse{

	private Long id;
	private String name;
	private Double balance;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
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

	public AccountResponse(Long id, String name, Double balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	
	public static AccountResponse fromEntity(AccountEntity entity) {
		return new AccountResponse(entity.getId(),entity.getName(),entity.getBalance());
	}
}
