package com.jv.crud_operation.model.entity.reuest.address;

import com.jv.crud_operation.model.entity.AddressEntity;

public class AddressEntityRequest {
	private String village;
	private String commune;
	private String destrict;
	private String provice;
	
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public String getCommune() {
		return commune;
	}
	public void setCommune(String commune) {
		this.commune = commune;
	}
	public String getDestrict() {
		return destrict;
	}
	public void setDestrict(String destrict) {
		this.destrict = destrict;
	}
	public String getProvice() {
		return provice;
	}
	public void setProvice(String provice) {
		this.provice = provice;
	}
	
	
	public AddressEntity toEntity() {
		AddressEntity address=new AddressEntity();
		address.setVillage(this.getVillage());
		address.setCommune(this.getCommune());
		address.setDestrict(this.getDestrict());
		address.setProvince(this.getProvice());
		return address;
	}
	
	
	
}
