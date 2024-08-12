package com.jv.crud_operation.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.jv.crud_operation.model.entity.ProductEnitty;
import com.jv.crud_operation.model.entity.TagEntity;
import com.jv.crud_operation.model.entity.reuest.product.ProductRequest;
import com.jv.crud_operation.repository.ProductRepository;
import com.jv.crud_operation.repository.TagRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;
	private final TagRepository tagrepository;
	
	public ProductService(ProductRepository productRepository, TagRepository tagrepository) {
		this.productRepository = productRepository;
		this.tagrepository = tagrepository;
	}

	public ProductEnitty saveProduct(ProductRequest req) throws Exception {
		//#1. casting from request model to Eintity
		ProductEnitty data=req.toEntity();
		//#2.Validate if tag exist or not
	   List<TagEntity>foundTagList=this.tagrepository.findAllById(req.getTagId());
	   Set<TagEntity>foundTags=Set.copyOf(foundTagList);
	   //#3.set Tag data 
		data.setTags(foundTags);
		
		try {
			return this.productRepository.save(data);
		} catch (Exception e) {
			throw new Exception(e);
		}
		

		
		
		
//#0. To have List of Tag
//        List<TagEntity> tags = tagrepository.findAllById(req.getTagId());
//#1. CastCat Data 
//		ProductEnitty data=req.toEntity(tags);
//#2. Prepare Data 
//		data.setName(req.getName());
//		data.setDescription(req.getDescription());
//		data.setPrice(req.getPrice());
//		data.setTags(tags);
//		System.out.println("Tage "+data.getTags());
//#3. Save Data and return 
//		return productRepository.save(data);
		
	}
}