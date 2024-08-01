package com.jv.crud_operation.service;

import org.springframework.stereotype.Service;

import com.jv.crud_operation.model.entity.AddressEntity;
import com.jv.crud_operation.model.entity.UserEntity;
import com.jv.crud_operation.model.entity.reuest.user.UserRequest;
import com.jv.crud_operation.repository.AddressRepository;
import com.jv.crud_operation.repository.UserRepository;

@Service
public class UserService {
	//Inititate the Userreposigtory 
	private final UserRepository userRepository;
	private final AddressRepository addressRepository;

	public UserService(UserRepository userRepository, AddressRepository addressRepository) {
		this.userRepository = userRepository;
		this.addressRepository = addressRepository;
	}
	//to save user 
	public UserEntity register(UserRequest userRequest) {
		
		UserEntity userEntity=userRequest.toEntity(new UserEntity());
		
		AddressEntity addressEntity=userRequest.getAddress().toEntity();
		addressEntity=addressRepository.save(addressEntity);
		userEntity.setAddress(addressEntity);
		return userRepository.save(userEntity);
	}
	
		//Save 
}
