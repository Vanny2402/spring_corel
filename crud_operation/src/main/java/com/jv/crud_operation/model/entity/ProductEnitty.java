package com.jv.crud_operation.model.entity;

import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
public class ProductEnitty {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50,nullable = false)
	private String name;
	
	@Column(nullable = false)
	private Double price;
	
	@Basic
	private String description;
	
	@ManyToMany
	@JoinTable(name="product_tags",joinColumns =@JoinColumn(name="product_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name="tag_id",referencedColumnName = "id"))
	private List<TagEntity> tags;
	
	
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
	
	public List<TagEntity> getTags() {
		return tags;
	}

	public void setTags(List<TagEntity> tags) {
		this.tags = tags;
	}



}
