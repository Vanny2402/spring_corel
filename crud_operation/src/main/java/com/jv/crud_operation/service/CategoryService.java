package com.jv.crud_operation.service;

import java.util.Optional;

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
	
	public CategoryEntity updage(Long id,CategoryRequest request) throws Exception {
		
		//Check if id exist or not 
		CategoryEntity foundData=this.categoryRepository.findById(id).orElseThrow(()-> new 
				NotFoundException("Category not found!"));
		//Prepare Date To Updae
		//#1
//		foundData.setName(request.getName());
//		foundData.setDescription(request.getDescription());
		
		//#2
		foundData.setName(request.getName()==null ?foundData.getName():request.getName() );
		foundData.setDescription(request.getDescription()==null ?foundData.getDescription():request.getDescription());
		
		//Update data
		try {
			return this.categoryRepository.save(foundData);
		} catch (Exception ex) {
			throw new Exception(ex);
		}

	
	}
	
	
}
