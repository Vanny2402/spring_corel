package com.jv.crud_operation.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jv.crud_operation.model.entity.PostCommentEntity;
import com.jv.crud_operation.model.entity.response.comment.CommentResponse;
import com.jv.crud_operation.model.entity.response.comment.ShortCommentResponse;
import com.jv.crud_operation.model.entity.reuest.comment.CommentRequest;
import com.jv.crud_operation.model.entity.reuest.comment.UpdateCommentRequest;
import com.jv.crud_operation.service.PostCommentService;

@RestController
@RequestMapping("comment")
public class CommentController {

	private final PostCommentService postCommentService;

	public CommentController(PostCommentService postCommentService) {
		this.postCommentService = postCommentService;
	}
	
	@PostMapping()
	public ResponseEntity<ShortCommentResponse> create(@RequestBody CommentRequest request) throws Exception{
		
		PostCommentEntity data=this.postCommentService.create(request);
		return ResponseEntity.ok(ShortCommentResponse.fromEntity(data));
		
	}
	
	@GetMapping()
	public ResponseEntity<List<CommentResponse>> findAll(@RequestParam(required = false) Long postId){
		List<CommentResponse> data=this.postCommentService.findAll(postId).stream().map(CommentResponse::fromEntity).toList();
		return ResponseEntity.ok(data);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ShortCommentResponse> update(@PathVariable Long id,@RequestBody UpdateCommentRequest request) throws Exception{
		PostCommentEntity data=this.postCommentService.update(id, request);
		return ResponseEntity.ok(ShortCommentResponse.fromEntity(data));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ShortCommentResponse> delete(@PathVariable Long id) throws Exception{
		
		PostCommentEntity data=this.postCommentService.delet(id);
		return ResponseEntity.ok(ShortCommentResponse.fromEntity(data));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
