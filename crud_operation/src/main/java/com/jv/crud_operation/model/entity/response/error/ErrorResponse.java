package com.jv.crud_operation.model.entity.response.error;

import java.io.Serializable;

public class ErrorResponse implements Serializable {

	private String message;
	private Short status;


	public String getMessage() {
		return message;
	}
	public Short getStatus() {
		return status;
	}

	public ErrorResponse(String message, Short status) {
		super();
		this.message = message;
		this.status = status;
	}
}
