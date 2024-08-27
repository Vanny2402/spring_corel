package com.jv.crud_operation.model.entity.response.comment;

import java.io.Serializable;

import com.jv.crud_operation.model.entity.PostCommentEntity;
import com.jv.crud_operation.model.entity.response.post.PostResponse;
import com.jv.crud_operation.model.entity.response.post.PostResponse;

public class ShortCommentResponse implements Serializable {
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

	public ShortCommentResponse(Long id, String comment) {
		this.id = id;
		this.comment = comment;
	}

	public static ShortCommentResponse fromEntity(PostCommentEntity entity) {
//		System.out.println("Hello Post: "+entity.getPost().getTitle());
//		return new CommentResponse(entity.getId(), entity.getComment(),ShotPostResponse.fromEntity(entity.getPost()));
		return new ShortCommentResponse(entity.getId(),entity.getComment());
	}
}
