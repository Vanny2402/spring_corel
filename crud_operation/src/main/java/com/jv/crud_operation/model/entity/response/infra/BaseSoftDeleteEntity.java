package com.jv.crud_operation.model.entity.response.infra;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@MappedSuperclass
public abstract class BaseSoftDeleteEntity<ID extends Serializable> extends BaseAuditEntity<ID> {

	@Temporal(TemporalType.TIMESTAMP)
	private Date deletedAt;
	
	
	public Date getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}
}
