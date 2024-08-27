package com.jv.crud_operation.model.entity.response.tag;

import java.io.Serializable;

import com.jv.crud_operation.model.entity.TagEntity;

public class TagResponse implements Serializable{

	private Long id;
	private String tagName;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	
	public TagResponse(Long id, String tagName) {
		this.id = id;
		this.tagName = tagName;
	}
	
	public static TagResponse fromEntity(TagEntity entity) {
		if(entity==null)
			return null;
		return new TagResponse(entity.getId(),entity.getTagName());
	}
}
