package com.jv.crud_operation.model.entity.response.comment;

import java.io.Serializable;

import com.jv.crud_operation.model.entity.PostCommentEntity;
import com.jv.crud_operation.model.entity.response.post.ShotPostResponse;

public class CommentResponse implements Serializable {

	private ShotPostResponse post;
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

	public ShotPostResponse getPost() {
		return post;
	}
	public CommentResponse(Long id, String comment,ShotPostResponse post) {
		this.id = id;
		this.comment = comment;
		this.post=post;
	}

	public static CommentResponse fromEntity(PostCommentEntity entity) {
		return new CommentResponse(entity.getId(), entity.getComment(),ShotPostResponse.fromEntity(entity.getPost()));
	}
}
