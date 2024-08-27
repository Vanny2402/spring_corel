package com.jv.crud_operation.model.entity;

import com.jv.crud_operation.model.entity.response.infra.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="postComments")
public class PostCommentEntity extends BaseEntity<Long>{

	@Column(nullable = false,length = 250)
	private String comment;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="postId",nullable = false,referencedColumnName = "id")
	private PostEntity post;
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public PostEntity getPost() {
		return post;
	}

	public void setPost(PostEntity post) {
		this.post = post;
	}


}
