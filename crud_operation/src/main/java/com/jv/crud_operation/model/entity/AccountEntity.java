package com.jv.crud_operation.model.entity;

import java.util.Set;

import com.jv.crud_operation.model.entity.response.infra.BaseSoftDeleteEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="accounts")
public class AccountEntity extends BaseSoftDeleteEntity<Long>{	
	
	@Column(length = 15,nullable = false,unique = true)
	private String name;
	
	@Column(nullable =  false)
	private Double balance;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "account",cascade = CascadeType.ALL)
	@Column(name="Accounthistory_id")
	private Set<AccountHistoryEntity> accountHistory;


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
	
	public Set<AccountHistoryEntity> getAccountHistory() {
		return accountHistory;
	}

	public void setAccountHistory(Set<AccountHistoryEntity> accountHistory) {
		this.accountHistory = accountHistory;
	}


}
