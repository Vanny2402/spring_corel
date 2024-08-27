package com.jv.crud_operation.model.entity;

import com.jv.crud_operation.constant.CrudTypeEnum;
import com.jv.crud_operation.model.entity.response.infra.BaseSoftDeleteEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="AccountHistory")
public class AccountHistoryEntity extends BaseSoftDeleteEntity<Long>{	
	
	@Column(length = 15,nullable = false)
	private String name;
	
	@Column(nullable =  false)
	private Double balance;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private CrudTypeEnum type;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="account_id")
	private AccountEntity account;
	
	public CrudTypeEnum getType() {
		return type;
	}
	public void setType(CrudTypeEnum type) {
		this.type = type;
	}

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

	public AccountEntity getAccount() {
		return account;
	}
	public void setAccount(AccountEntity account) {
		this.account = account;
	}
}
