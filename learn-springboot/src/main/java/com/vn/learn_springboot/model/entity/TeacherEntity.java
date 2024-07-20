package com.vn.learn_springboot.model.entity;


import java.util.Objects;

import org.hibernate.Hibernate;

import com.vn.learn_springboot.embadable.GeneralInfo;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="teacher")
public class TeacherEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Embedded
	private GeneralInfo generalInfor;
	
	public GeneralInfo getGeneralInfor() {
		return generalInfor;
	}

	public void setGeneralInfor(GeneralInfo generalInfor) {
		this.generalInfor = generalInfor;
	}

	
	@Embedded
	@AttributeOverrides(value = {
			@AttributeOverride(name = "firstname",column =@Column(name = "teacher_firstname", length = 20, nullable = false)),
            @AttributeOverride(name = "lastname", column = @Column(name = "teacher_lastname", length = 10, nullable = false)),
            @AttributeOverride(name = "gender", column = @Column(name = "teacher_gender", length = 10, nullable = false)),
            @AttributeOverride(name = "phone", column = @Column(name = "teacher_phone", length = 15, nullable = false))
			
	})
    private GeneralInfo generalInfoTeacher;
    
    
    
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if(this==o) return true;
		if(o==null || Hibernate.getClass(this)!=Hibernate.getClass(o)) return false;
		TeacherEntity that=(TeacherEntity) o;
		return id!= null && Objects.equals(id,that.id);
	}
	
}
