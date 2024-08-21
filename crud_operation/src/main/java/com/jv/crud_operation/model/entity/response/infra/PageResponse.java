package com.jv.crud_operation.model.entity.response.infra;

import java.io.Serializable;

public class PageResponse implements Serializable {


	private int page;
	private int pageSize;
	private int totalPage;
	private int totalCount;
	
	public int getPage() {
		return page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	
	public PageResponse(int page, int pageSize, int totalPage, int totalCount) {
		this.page = page;
		this.pageSize = pageSize;
		this.totalPage = totalPage;
		this.totalCount = totalCount;
	}

}
