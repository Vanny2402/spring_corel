package com.jv.crud_operation.service;

import org.springframework.stereotype.Service;

import com.jv.crud_operation.exception.AlreadyExistException;
import com.jv.crud_operation.model.entity.UserEntity;
import com.jv.crud_operation.model.entity.reuest.user.UserEntityRequest;
import com.jv.crud_operation.repository.AddressRepository;
import com.jv.crud_operation.repository.UserRepository;

@Service
public class UserService {

	private final AddressRepository addressRepository;
	private final UserRepository userRepository;
	public UserService(AddressRepository addressRepository, UserRepository userRepository) {
		this.addressRepository = addressRepository;
		this.userRepository = userRepository;
	}

	
	public UserEntity save(UserEntityRequest userRequest) throws Exception{
		//To check if you exist or in system or not
		if(this.userRepository.existsByUsername(userRequest.getUsername())) {
			throw new AlreadyExistException("User already exist!");
		}
	
		//Save user to DB
		UserEntity user=userRequest.toEntity();
		UserEntity u= userRepository.save(user);
		this.addressRepository.save(userRequest.getAddress());
		return u;
	}
}
