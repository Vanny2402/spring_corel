package com.vn.learn_springboot.model.entity;

import java.util.Objects;

import org.hibernate.Hibernate;

import com.vn.learn_springboot.infrastructure.converter.ContactObjectConverter;
import com.vn.learn_springboot.model.object.ContactObject;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@Column(length = 30,nullable = false)
	private String username;
	
	
	@Column(length = 100)
	@Convert(converter = ContactObjectConverter.class)
	private ContactObject contact;
	
	public ContactObject getContact() {
		return contact;
	}

	public void setContact(ContactObject contact) {
		this.contact = contact;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	
	@Override
	public boolean equals(Object o) {
		if(this==o) return true;
		if(o==null || Hibernate.getClass(this)!=Hibernate.getClass(o)) return false;
		UserEntity that=(UserEntity) o;
		return id!=null && Objects.equals(id,that.id);
	}
	
	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
	
}
