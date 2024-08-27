package com.jv.crud_operation.model.entity.response.post;

import java.io.Serializable;

import com.jv.crud_operation.model.entity.PostEntity;

public class ShotPostResponse implements Serializable{
	
	private Long id;
	private String title;

	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public ShotPostResponse(Long id, String title) {
		this.id = id;
		this.title = title;
	}
	
	public static ShotPostResponse fromEntity(PostEntity entity) {
		return new ShotPostResponse(entity.getId(), entity.getTitle());
	}
	
}
