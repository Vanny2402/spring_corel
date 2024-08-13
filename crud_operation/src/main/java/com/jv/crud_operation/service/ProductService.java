package com.jv.crud_operation.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.jv.crud_operation.exception.NotFoundException;
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
		/*1. casting from request model to Entity */
		ProductEnitty data=req.toEntity();
		/*2.Validate if tag exist or not*/
	   List<TagEntity>foundTagList=this.tagrepository.findAllById(req.getTagId());
	   Set<TagEntity>foundTags=Set.copyOf(foundTagList);
	   /*3.set Tag data */
		data.setTags(foundTags);
		try {
			return this.productRepository.save(data);
		} catch (Exception e) {
			throw new Exception(e);
		}
/*		
  0. To have List of Tag
  		List<TagEntity> tags = tagrepository.findAllById(req.getTagId());
  1. CastCat Data 
  		ProductEnitty data=req.toEntity(tags);
  2. Prepare Data 
  		data.setName(req.getName());
  		data.setDescription(req.getDescription());
		data.setPrice(req.getPrice());
		data.setTags(tags);
		System.out.println("Tag "+data.getTags());
3. Save Data and return 
		return productRepository.save(data);		
*/
	}
	public List<ProductEnitty> findAll(){	
		List<ProductEnitty> data = productRepository.findAll();
		return data;
	}
	
	public ProductEnitty finOne(Long id) throws Exception {
		return productRepository.findById(id).orElseThrow(()-> new Exception("The Product is not exit in system! "));
	}
	
	
	public List<TagEntity> getTagList(List<Long> id){	
		List<TagEntity> data =tagrepository.findAllById(id);
		return data;
	}
	public ProductEnitty update(Long id, ProductRequest req) throws Exception {
		/* 
		 * 1.fine the product if exist or not 
		 * 2.Convert list of Tag
		 * 3.Prepare Data
		 * 4.Save data
		 * */
		ProductEnitty foundProduct=finOne(id);
		List<TagEntity> lt=getTagList(req.getTagId());
		Set<TagEntity>ls =new HashSet<>(lt);
		
		foundProduct.setName(req.getName());
		foundProduct.setDescription(req.getDescription());
		foundProduct.setPrice(req.getPrice());
		foundProduct.setTags(ls);
		
		for(TagEntity s :lt) {
			System.out.print("\nHere is TagName: "+s.getTagName());
		}
		
		return productRepository.save(foundProduct);
	}
	public ProductEnitty delete(Long id) throws NotFoundException {
		/*1.To find if the product is exist or not 
		 * 2.remove */
		ProductEnitty foundProduct =productRepository.findById(id).orElseThrow(()-> new NotFoundException("The product is not exist! "));
		productRepository.delete(foundProduct);
		return foundProduct;
		
	}
	
}