package com.vn.learn_springboot.embadable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable

public class ContactIinfo {

	@Column(name="contact_firstname")
	private String firstname;
	@Column(name="constact_lastname")
	private String lastname;
	@Column(name="contact_phone")
	private String phone;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}


}
