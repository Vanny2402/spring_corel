package com.jv.crud_operation.service;

import org.springframework.stereotype.Service;

import com.jv.crud_operation.model.entity.PostCommentEntity;
import com.jv.crud_operation.model.entity.reuest.comment.CommentRequest;

@Service
public class PostCommentRepository {

	private final PostCommentRepository postCommentRepository;

	public PostCommentRepository(PostCommentRepository postCommentRepository) {
		this.postCommentRepository = postCommentRepository;
	}

	
	
	public PostCommentEntity create(CommentRequest req) {
		
		//prepare request model to entity model
		PostCommentEntity request =req.toEntity();
		//validate that post exist or not
		//then set post to post comment entity model
		//Save record to Database 
		
		return null;
	}
}
