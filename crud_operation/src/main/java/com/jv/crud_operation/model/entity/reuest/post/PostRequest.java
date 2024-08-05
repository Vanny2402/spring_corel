package com.jv.crud_operation.model.entity.reuest.post;

import java.io.Serializable;

import com.jv.crud_operation.model.entity.PostEntity;

public class PostRequest implements Serializable {

	private String title;
	private String description;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public PostEntity toEntity() {
		PostEntity post=new PostEntity();
		post.setTitle(this.getTitle());
		post.setDescription(this.getDescription());
		
		return post;
	}

	
}
