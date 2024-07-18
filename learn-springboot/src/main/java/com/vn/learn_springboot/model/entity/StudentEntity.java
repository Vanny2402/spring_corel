package com.vn.learn_springboot.model.entity;

import java.util.Date;
import java.util.Objects;

import org.hibernate.Hibernate;

import com.vn.learn_springboot.constant.enums.GenerEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
@Table(name="students")
public class StudentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="stu_id")
	private Long id;
	@Column(name="f_name",length = 30,nullable =true)
	private String firstName;
	
	@Column(name="l_name",length = 30,nullable =true)
	private String lastName;
	
	
	@Column(name="dob")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dob;
	
	
	@Enumerated(EnumType.STRING)
	private GenerEnum gender;
	
	
	@Column(name = "subject",columnDefinition ="varchar (150) default 'MIS'")
	private String subject;
	
	
	@Transient
	private String fullname;
	
	public String getFullname() {
		this.fullname = this.firstName+this.lastName;
		return this.fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = this.firstName+this.lastName;
	}

	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

	
	public void setId(Long id) {
		this.id=id;
	}
	public Long getId(){

		return this.id;
	}
	
	
	@Override
	public boolean equals(Object o) {
		if(this==o) return true;
		if(o==null || Hibernate.getClass(this)!=Hibernate.getClass(o)) return false;
		StudentEntity that=(StudentEntity) o;
		return id!=null && Objects.equals(id,that.id);
	}
	
	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
	
}
