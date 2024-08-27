package com.jv.crud_operation.model.entity.response.comment;

import java.io.Serializable;

import com.jv.crud_operation.model.entity.PostCommentEntity;
import com.jv.crud_operation.model.entity.response.post.PostResponse;
import com.jv.crud_operation.model.entity.response.post.PostResponse;

public class CommentResponse implements Serializable {

	private PostResponse post;
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

	public PostResponse getPost() {
		return post;
	}
	public CommentResponse(Long id, String comment,PostResponse post) {
		this.id = id;
		this.comment = comment;
		this.post=post;
	}

	public static CommentResponse fromEntity(PostCommentEntity entity) {
//		System.out.println("Hello Post: "+entity.getPost().getTitle());
//		return new CommentResponse(entity.getId(), entity.getComment(),ShotPostResponse.fromEntity(entity.getPost()));
		return new CommentResponse(entity.getId(),entity.getComment(),PostResponse.fromEntity(entity.getPost()));
	}
}
