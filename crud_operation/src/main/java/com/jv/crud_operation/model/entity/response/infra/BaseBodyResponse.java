package com.jv.crud_operation.model.entity.response.infra;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class BaseBodyResponse implements Serializable {

	private final Object data;
	@JsonInclude(Include.NON_NULL)
	private PageResponse page;
	private Object status;
	
	public Object getData() {
		return data;
	}
	public PageResponse getPage() {
		return page;
	}
	public Object getStatus() {
		return status;
	}
	
	public BaseBodyResponse(Object data, PageResponse page, Object status) {
		this.data = data;
		this.page = page;
		this.status = status;
	}
	
	public static ResponseEntity<BaseBodyResponse> success (Page<BaseResponse> response,String message){
		
		List<BaseResponse>data=response.getContent();
		
		PageResponse page;
		
		if(response.getPageable().isUnpaged()) page = null;
		else page=new PageResponse(response.getNumber()+1,response.getSize(),response.getTotalPages(),(int)response.getTotalElements());
		StatusResponse status=new StatusResponse(message,(short)200);
		return ResponseEntity.ok(new BaseBodyResponse(data, page, status));
	}
	
	
	public static ResponseEntity<BaseBodyResponse> success(BaseResponse response,String message){
		StatusResponse status=new StatusResponse(message,(short)200);
		return ResponseEntity.ok(new BaseBodyResponse(response, null, status));
	}
	
	public static ResponseEntity<BaseBodyResponse> createsuccess(BaseResponse response,String message){
		StatusResponse status=new StatusResponse(message,(short)201);
		return ResponseEntity.ok(new BaseBodyResponse(response, null, status));
	}
	
}
