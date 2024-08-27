package com.jv.crud_operation.model.entity.response.post;

import java.io.Serializable;

import com.jv.crud_operation.model.entity.PostEntity;

public class PostResponse implements Serializable{
	
	private Long id;
	private String title;
	private String description;
	

	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}

	public PostResponse(Long id, String title, String description) {
		this.id = id;
		this.title = title;
		this.description = description;
	}
	
	public static PostResponse fromEntity(PostEntity entity) {
		return new PostResponse(entity.getId(), entity.getTitle(), entity.getDescription());
	}
	
}
