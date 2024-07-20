package com.vn.learn_springboot.embadable;


import com.vn.learn_springboot.constant.enums.GenerEnum;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class GeneralInfo {
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public GenerEnum getGender() {
		return gender;
	}

	public void setGender(GenerEnum gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(length = 10,nullable = false)
	private String firstname;
	@Column(length = 10)
	private String lastname;
	
	@Column(length = 10,nullable = false)
	@Enumerated(EnumType.STRING)
	private GenerEnum gender;
	
	@Column(length = 15)
	private String phone;
	

}
