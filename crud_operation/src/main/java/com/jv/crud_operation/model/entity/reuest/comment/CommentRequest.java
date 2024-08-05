package com.jv.crud_operation.model.entity.reuest.comment;

import java.io.Serializable;

import com.jv.crud_operation.model.entity.PostCommentEntity;

public class CommentRequest implements Serializable{
	private String comment;
	private Long postId;
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Long getPostId() {
		return postId;
	}
	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public PostCommentEntity toEntity() {
		
		PostCommentEntity postCom=new PostCommentEntity();
		postCom.setComment(this.getComment());
		return postCom; 
		
	}
}
