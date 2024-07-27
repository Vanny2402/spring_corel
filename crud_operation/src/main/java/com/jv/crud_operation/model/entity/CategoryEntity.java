package com.jv.crud_operation.model.entity;

import java.util.Objects;

import org.hibernate.Hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="category")
public class CategoryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
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

	@Column(nullable = false,length = 30,unique = true)
	private String name;
	
	@Column(length = 100)
	private String description;
	
	
	@Override
	public boolean equals(Object o) {
		if(this==o) return true;
		if(o==null || Hibernate.getClass(this)!=Hibernate.getClass(o)) return false;
		CategoryEntity that=(CategoryEntity) o;
		return id!=null && Objects.equals(id,that.id);
	}
	
	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
	
	
	
	
	
	
}
