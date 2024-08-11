package com.jv.crud_operation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jv.crud_operation.exception.AlreadyExistException;
import com.jv.crud_operation.model.entity.TagEntity;
import com.jv.crud_operation.model.entity.response.tag.TagResponse;
import com.jv.crud_operation.model.entity.reuest.tag.TagRequest;
import com.jv.crud_operation.service.TagService;

@RestController
@RequestMapping("tag")
public class TagController {

	private final TagService tagService;

	public TagController(TagService tagService) {
		this.tagService = tagService;
	}

	@PostMapping("")
	public ResponseEntity<TagResponse> saveTag(@RequestBody TagRequest request) throws AlreadyExistException{
		TagEntity data = this.tagService.createTage(request);
		return ResponseEntity.ok(TagResponse.fromEntity(data));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TagResponse> saveTag(@PathVariable Long id, @RequestBody TagRequest request) throws Exception{
		TagEntity data = this.tagService.updateTag(id,request);
		return ResponseEntity.ok(TagResponse.fromEntity(data));
	}
	
}
