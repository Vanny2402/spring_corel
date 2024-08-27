package com.jv.crud_operation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jv.crud_operation.model.entity.PostEntity;
import com.jv.crud_operation.model.entity.reuest.post.PostRequest;
import com.jv.crud_operation.repository.PostRepository;

@Service
public class PostService {
	private final PostRepository postRepository;

	@Autowired
	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}


	public PostEntity create(PostRequest request) throws Exception {
		
		try {
			return this.postRepository.save(request.toEntity());
			
		}catch (Exception ex) {
			throw new Exception(ex);

		}
		
	}
	
	public List<PostEntity> findAll(){
		return this.postRepository.findAll();
	}
	
	public PostEntity findOne(Long id) throws Exception {
	
		PostEntity post=postRepository.findById(id).orElseThrow(()->new Exception("The Data is not exist!"));
		return post;
	}
	
	
	public PostEntity update(Long id,PostRequest request) throws Exception {
		
		PostEntity post=findOne(id);
		post.setTitle(request.getTitle());
		post.setDescription(request.getDescription());
		return this.postRepository.save(post);
	}
	

	public PostEntity delete(Long id) throws Exception {
		PostEntity post=findOne(id);
		this.postRepository.deleteById(id);
		return post;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
