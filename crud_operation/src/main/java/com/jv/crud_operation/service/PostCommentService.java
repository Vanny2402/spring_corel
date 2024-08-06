package com.jv.crud_operation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jv.crud_operation.model.entity.PostCommentEntity;
import com.jv.crud_operation.model.entity.PostEntity;
import com.jv.crud_operation.model.entity.reuest.comment.CommentRequest;
import com.jv.crud_operation.repository.PostCommentRepository;
import com.jv.crud_operation.repository.PostRepository;

@Service
public class PostCommentService {
	private final PostCommentRepository postCommentRepository;
	private final PostRepository postRepository;
	
	public PostCommentService(PostCommentRepository postCommentRepository, PostRepository postRepository) {
		this.postCommentRepository = postCommentRepository;
		this.postRepository = postRepository;
	}

	public PostCommentEntity create(CommentRequest req) throws Exception {
		
		//prepare request model to entity model
		PostCommentEntity request =req.toEntity();
		//validate that post exist or not
		PostEntity foundPost=this.postRepository.findById(req.getPostId()).orElseThrow(()->new Exception("There is no this Post"));
		
		//then set post to post comment entity model
		request.setPost(foundPost);
		//Save record to Database 
		try {
			
			return this.postCommentRepository.save(request);
			
		} catch (Exception ex) {
			throw new Exception(ex);
		}
		
	}
	
	public List<PostCommentEntity> findAll(Long postId){
		
		if(postId==null) return this.postCommentRepository.findAll();
		else return this.postCommentRepository.findAllByPostId(postId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
