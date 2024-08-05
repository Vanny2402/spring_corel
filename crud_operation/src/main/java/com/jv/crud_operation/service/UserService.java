package com.jv.crud_operation.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.jv.crud_operation.exception.AlreadyExistException;
import com.jv.crud_operation.exception.BadRequestException;
import com.jv.crud_operation.exception.NotFoundException;
import com.jv.crud_operation.model.entity.AddressEntity;
import com.jv.crud_operation.model.entity.UserEntity;
import com.jv.crud_operation.model.entity.reuest.user.UserEntityRequuest;
import com.jv.crud_operation.model.entity.reuest.user.UserLoginRequest;
import com.jv.crud_operation.repository.AddressRepository;
import com.jv.crud_operation.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Transactional
	public UserEntity register(UserEntityRequuest userRequest) throws Exception {
		// Prepare Request to Entity
		UserEntity request = userRequest.toEntity();
		// If username already exists, throw Error
		if (this.userRepository.existsByUsername(userRequest.getUsername()))
			throw new AlreadyExistException("Username Already exist!");

		try {
			// Save User Request
			UserEntity user = this.userRepository.save(request);
			return this.userRepository.save(user);
		} catch (Exception ex) {
			throw new Exception(ex);
		}
	}

	public List<UserEntity> findAll() {
		return this.userRepository.findAll();
	}

	public UserEntity findOne(Long id) throws NotFoundException {
		return this.userRepository.findById(id).orElseThrow(() -> new NotFoundException("This user is not Found"));
	}

	public UserEntity login(UserLoginRequest request) throws BadRequestException {
		return userRepository.findByUsername(request.getUsername())
				.orElseThrow(() -> new BadRequestException("Invalid Username"));
	}

	public UserEntity update(Long id, UserEntityRequuest req) throws Exception {
		UserEntity foundUser = this.userRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("User not found"));
		
		System.out.println("Name From DB: "+foundUser.getUsername() +"\n Name Request: "+req.getUsername());
		if (foundUser.getUsername().equals(req.getUsername())) {
			throw new AlreadyExistException("Username already exists!");
		}else {
			foundUser.setUsername(req.getUsername());
		}
	
		if (req.getAddress().getAddress()!= null) {
			if (foundUser.getAddress() != null) {
                foundUser.setAddress(null);
                userRepository.flush();
            }
			foundUser.setAddress(req.toEntity(foundUser));
		} else {
			foundUser.setAddress(null);
		}
		
		try {
			return this.userRepository.save(foundUser);
		} catch (Exception ex) {
			throw new Exception(ex);
		}
	}
	public void delete(Long id) throws Exception {
		
		try {
			
			this.userRepository.deleteById(id);
		} catch (Exception ex) {
			throw new Exception(ex);
		}
	}
	

	
	
}
