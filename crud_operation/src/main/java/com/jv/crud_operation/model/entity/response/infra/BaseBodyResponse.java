package com.jv.crud_operation.model.entity.response.infra;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public class BaseBodyResponse implements Serializable {

	private List<BaseResponse>data;
	private PageResponse page;
	private Object status;
	
	public List<BaseResponse> getData() {
		return data;
	}
	public PageResponse getPage() {
		return page;
	}
	public Object getStatus() {
		return status;
	}
	
	public BaseBodyResponse(List<BaseResponse> data, PageResponse page, Object status) {
		this.data = data;
		this.page = page;
		this.status = status;
	}
	
	public static ResponseEntity<BaseBodyResponse> success (Page<BaseResponse> response,String message){
		
		List<BaseResponse>data=response.getContent();
		PageResponse page=new PageResponse(response.getNumber()+1,response.getSize(),response.getTotalPages(),(int)response.getTotalElements());
		StatusResponse status=new StatusResponse(message,(short)200);
		
		return ResponseEntity.ok(new BaseBodyResponse(data, page, status));
	}
	
}
