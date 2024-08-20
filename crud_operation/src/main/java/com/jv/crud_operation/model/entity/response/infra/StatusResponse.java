package com.jv.crud_operation.model.entity.response.infra;

public class StatusResponse {
	private String message;
	private short code;
	
	protected StatusResponse(String message, short code) {
		this.message = message;
		this.code = code;
	}

	
	public String getMessage() {
		return message;
	}
	public short getCode() {
		return code;
	}

}
