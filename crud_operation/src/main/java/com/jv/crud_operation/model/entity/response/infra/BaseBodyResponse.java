package com.jv.crud_operation.model.entity.response.infra;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;

public class BaseBodyResponse implements Serializable {

	private List<BaseResponse> data;
	private PageResponse page;
	private StatusResponse status;
	
	public PageResponse getPage() {
		return page;
	}
	public StatusResponse getStatus() {
		return status;
	}
	
	public List<BaseResponse> getData() {
		return data;
	}
	
	public BaseBodyResponse(List<BaseResponse> data, PageResponse page, StatusResponse status) {
		this.data = data;
		this.page = page;
		this.status = status;
	}

	public static BaseBodyResponse success(Page<BaseResponse> resonse,String message){
		List<BaseResponse>data=resonse.getContent();
		PageResponse page=new PageResponse(resonse.getNumber()+1,resonse.getSize(),resonse.getTotalPages(),(int) resonse.getTotalElements());
		StatusResponse status=new StatusResponse(message,(short) 200);
		return new BaseBodyResponse(data,page, status);
	}
}
