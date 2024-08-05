package com.jv.crud_operation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jv.crud_operation.model.entity.PostEntity;
import com.jv.crud_operation.model.entity.response.post.PostResponse;
import com.jv.crud_operation.model.entity.reuest.post.PostRequest;
import com.jv.crud_operation.service.PostService;

@RestController
@RequestMapping("post")
public class PostController {
	
	private final PostService postService;
	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<PostResponse> create(@RequestBody PostRequest request) throws Exception{
		PostEntity data=this.postService.create(request);
		return ResponseEntity.ok(PostResponse.fromEntity(data));
		
	}
	
	@GetMapping("")
	public ResponseEntity<List<PostResponse>> findAll() throws Exception{
		List<PostResponse> data =this.postService.findAll().stream().map(PostResponse::fromEntity).toList();
		return ResponseEntity.ok(data);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <PostResponse> findAll(@PathVariable Long id) throws Exception{
		PostEntity data=postService.findOne(id);
		return ResponseEntity.ok(PostResponse.fromEntity(data));
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity <PostResponse> findAll(@PathVariable Long id,@RequestBody PostRequest request) throws Exception{
		PostEntity data=postService.update(id, request);
		return ResponseEntity.ok(PostResponse.fromEntity(data));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity <Map<String,Object>> delete(@PathVariable Long id) throws Exception{
		this.postService.delete(id);
		Map<String,Object> response=new HashMap<>();
		response.put("Msg: ", "Deleted Post");
		return ResponseEntity.ok(response);
	}
	
	
	
	
	
	
	
	
	
}
