package com.jv.crud_operation.model.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jv.crud_operation.model.entity.response.infra.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tags")
public class TagEntity extends BaseEntity<Long>{	
	@Column(length = 15,nullable = false,unique = true)
	private String tagName;
	
	@ManyToMany(mappedBy = "tags")
	@JsonManagedReference
    private List<ProductEnitty> products;

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	
    public List<ProductEnitty> getProducts() {
		return products;
	}

	public void setProducts(List<ProductEnitty> products) {
		this.products = products;
	}
}
