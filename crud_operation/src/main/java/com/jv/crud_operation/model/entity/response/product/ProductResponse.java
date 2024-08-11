package com.jv.crud_operation.model.entity.response.product;

import java.io.Serializable;
import java.util.List;

import com.jv.crud_operation.model.entity.ProductEnitty;
import com.jv.crud_operation.model.entity.TagEntity;
import com.jv.crud_operation.model.entity.response.tag.TagResponse;

public class ProductResponse implements Serializable{
	private Long id;
	private String name;
	private String description;
	private Double price;
	private List<TagEntity> tag;
	
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public List<TagEntity> getTag() {
		return tag;
	}
	public void setTag(List<TagEntity> tag) {
		this.tag = tag;
	}
	
	public ProductResponse(Long id, String name, String description, Double price, List<TagEntity> tag) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.tag = tag;
	}
	
	
	public static ProductResponse fromEntity(ProductEnitty entity) {
		List<TagResponse> t=entity.getTags().stream().map(TagResponse::fromEntity).toList();
		return new ProductResponse(entity.getId(),entity.getName(),entity.getDescription(),entity.getPrice(),entity.getTags());
		
	}
	
}
