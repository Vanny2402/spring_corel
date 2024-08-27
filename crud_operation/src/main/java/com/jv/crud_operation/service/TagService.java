package com.jv.crud_operation.service;

import org.springframework.stereotype.Service;

import com.jv.crud_operation.exception.AlreadyExistException;
import com.jv.crud_operation.exception.NotFoundException;
import com.jv.crud_operation.model.entity.TagEntity;
import com.jv.crud_operation.model.entity.reuest.tag.TagRequest;
import com.jv.crud_operation.repository.TagRepository;

@Service
public class TagService {
	private final TagRepository tagRepository;

	public TagService(TagRepository tagRepository) {
		this.tagRepository = tagRepository;
	}

	public TagEntity createTage(TagRequest req) throws AlreadyExistException{
        if(this.tagRepository.existsByTagName(req.getTagName())) {
        	throw new AlreadyExistException("This Tag is already Exist");
        }
        TagEntity data=req.toEntity();
        data.setTagName(req.getTagName());
		return this.tagRepository.save(data);
		
	}
	
	public TagEntity updateTag(Long id,TagRequest req) throws Exception{
        if(this.tagRepository.existsByTagName(req.getTagName())) {
        	throw new AlreadyExistException("This Tag is already Exist");
        }
        
        TagEntity foundData=this.tagRepository.findById(id).orElseThrow(()-> new NotFoundException("This tag is not exist!"));
        foundData.setTagName(req.getTagName());
		return this.tagRepository.save(foundData);
		
	}
}
