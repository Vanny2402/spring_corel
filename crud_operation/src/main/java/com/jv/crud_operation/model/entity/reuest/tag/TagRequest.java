package com.jv.crud_operation.model.entity.reuest.tag;

import java.io.Serializable;
import java.util.List;

import com.jv.crud_operation.model.entity.TagEntity;

public class TagRequest implements Serializable {

	private String tagName;
	private Long id;

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TagEntity toEntity() {
		TagEntity tag = new TagEntity();
		tag.setTagName(this.tagName);
		return tag;
	}

	public List<TagEntity> toEntity(List<Long> ids) {
		return ids.stream().map(id -> {
			TagEntity tag = new TagEntity();
			tag.setId(id);
			tag.setTagName(this.tagName);
			return tag;
		}).toList();
	}
}
