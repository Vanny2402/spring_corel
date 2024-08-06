package com.jv.crud_operation.model.entity.response.comment;

import java.io.Serializable;

import com.jv.crud_operation.model.entity.PostCommentEntity;

public class CommentResponse implements Serializable {



	private Long id;
	private String comment;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	public CommentResponse(Long id, String comment) {
		this.id = id;
		this.comment = comment;
	}

	
	public static CommentResponse fromEntity(PostCommentEntity entity) {
		return new CommentResponse(entity.getId(), entity.getComment());
	}
}
