package com.jv.crud_operation.model.entity.response.infra;

import java.io.Serializable;

public class StatusResponse implements Serializable {


	private String message;
	private short code;
	
	public String getMessage() {
		return message;
	}
	public short getCode() {
		return code;
	}
	
	public StatusResponse(String message, short code) {
		this.message = message;
		this.code = code;
	}

}
