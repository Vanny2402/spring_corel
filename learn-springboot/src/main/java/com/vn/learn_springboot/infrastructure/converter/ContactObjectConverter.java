package com.vn.learn_springboot.infrastructure.converter;

import com.vn.learn_springboot.model.object.ContactObject;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class ContactObjectConverter implements AttributeConverter<ContactObject, String> {

	
	private final static String separator= ", ";
	@Override
	public String convertToDatabaseColumn(ContactObject contactObject) {
		if(contactObject==null) return null;
		
		StringBuilder sb=new StringBuilder();
		if(contactObject.getPhone()!=null && !contactObject.getPhone().isEmpty()) {
			sb.append(contactObject.getPhone());
			sb.append(separator);
		}
		
		if(contactObject.getAddress()!=null && !contactObject.getAddress().isEmpty()) {
			sb.append(contactObject.getAddress());
		}
		return sb.toString();
	}
	
	@Override
	public ContactObject convertToEntityAttribute(String dbData) {

		if(dbData ==null) return null;
		
		String[] pieces=dbData.split(separator);
		if(pieces ==null||pieces.length==0) return null;
		
		ContactObject contactObject=new ContactObject();
		String firstpiec= !pieces[0].isEmpty()?pieces[0]:null;
		
		if(dbData.contains(separator)) {
			contactObject.setPhone(firstpiec);
			if(pieces.length>= 2 && pieces[1]!=null && !pieces[1].isEmpty()) contactObject.setAddress(pieces[0]);
		}else {
			contactObject.setPhone(firstpiec);
		}
		
		return contactObject;
	}

	
}
