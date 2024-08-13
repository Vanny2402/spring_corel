package com.jv.crud_operation.model.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tags")
public class TagEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 15,nullable = false,unique = true)
	private String tagName;
	
	@ManyToMany(mappedBy = "tags")
	@JsonBackReference
    private List<ProductEnitty> products;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
