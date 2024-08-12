package com.jv.crud_operation.model.entity.reuest.product;

import java.io.Serializable;
import java.util.Set;

import com.jv.crud_operation.model.entity.ProductEnitty;

public class ProductRequest implements Serializable{
	
	private Long id;
	private String name;
	private Double price; 
	private String description;
	private Set<Long> tagId; 	


	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Set<Long> getTagId() {
		return tagId;
	}
	public void setTagId(Set<Long> tagId) {
		this.tagId = tagId;
	}

	
	
	public ProductEnitty toEntity() {
	ProductEnitty product=new ProductEnitty();
    product.setName(this.name);
	product.setPrice(this.price);
	product.setDescription(this.description);
	return product;
}
	
	
	
//	public ProductEnitty toEntity(List<TagEntity> tags) {
//		ProductEnitty product=new ProductEnitty();
//	    product.setName(this.name);
//		product.setPrice(this.price);
//		product.setDescription(this.description);
//		product.setTags(tags);
//		return product;
//	}
	
	
	
	
}
