package com.jv.crud_operation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jv.crud_operation.exception.AlreadyExistException;
import com.jv.crud_operation.exception.NotFoundException;
import com.jv.crud_operation.model.entity.CategoryEntity;
import com.jv.crud_operation.model.entity.reuest.CategoryRequest;
import com.jv.crud_operation.repository.CategoryRepository;

@Service
public class CategoryService {

	private final CategoryRepository categoryRepository;
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public CategoryEntity create(CategoryRequest request) throws Exception {
		//Prepare request
		CategoryEntity data=request.toEntity();
		//check name from reuest if exist in db or not 
		if(this.categoryRepository.existsByName(data.getName())) {
//			throw new Exception("Category name already exist! ");
			throw new AlreadyExistException("Category name already exist! ");
		}
		
		//Save Data 
		try {
			return categoryRepository.save(request.toEntity());
		} catch (Exception ex) {

			throw new Exception(ex);
		}
		
	}
	
	public CategoryEntity update(Long id,CategoryRequest request) throws NotFoundException {
		//#1 To find if Category exist or not
		CategoryEntity dataFilter=categoryRepository.findById(id).orElseThrow(()-> new NotFoundException("Category is not exsit"));
		//#2 Update data
//		dataFilter.setName(request.getName());
//		dataFilter.setDescription(request.getDescription());
		dataFilter.setName(request.getName()==null? dataFilter.getName():request.getName());
		dataFilter.setDescription(request.getDescription()==null? dataFilter.getDescription():request.getDescription());
		return this.categoryRepository.save(dataFilter);
	}

	
	public List<CategoryEntity> getAll() {
	    return	this.categoryRepository.findAll();
	}
	
	
	public CategoryEntity getOne(Long id) throws NotFoundException {
		// #1 to check if Category exist or not 
		CategoryEntity getCategory=this.categoryRepository.findById(id).orElseThrow(()-> new NotFoundException("This id is not exist in  system!"));
		// #2 get data and return to the controller 
		return getCategory;
	}
	
	
	public CategoryEntity delete(Long id) throws NotFoundException {
		// #1 To check if category is exist in system or not
		CategoryEntity category=getOne(id);
		// #2 Commit to delete
		this.categoryRepository.deleteById(id);
		return category;
	}
	
	
}
