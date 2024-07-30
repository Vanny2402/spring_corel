package com.jv.crud_operation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jv.crud_operation.exception.AlreadyExistException;
import com.jv.crud_operation.model.entity.UserEntity;
import com.jv.crud_operation.model.entity.reuest.user.UserEntityRequuest;
import com.jv.crud_operation.repository.AddressRepository;
import com.jv.crud_operation.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final AddressRepository addressRepository;

	@Autowired
	public UserService(UserRepository userRepository, AddressRepository addressRepository) {
		this.userRepository = userRepository;
		this.addressRepository = addressRepository;
	}

	public UserEntity rgister(UserEntityRequuest userRequest) throws Exception {
		// prepare Request to Entity
		UserEntity request = userRequest.toEntity();
		// if username already exist then throw Error
		if (this.userRepository.existsByUsername(userRequest.getUsername()))
			throw new AlreadyExistException("Username Already exist! ");

		try {

			// Save Request
			UserEntity user = this.userRepository.save(request);
			this.addressRepository.save(userRequest.getAddress().toEntity(user));
			return user;
		} catch (Exception ex) {
			throw new Exception(ex);
		}

	}

}
