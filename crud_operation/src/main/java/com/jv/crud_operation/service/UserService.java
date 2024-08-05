package com.jv.crud_operation.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

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
	private final AddressRepository addressRepository;

	@Autowired
	public UserService(UserRepository userRepository, AddressRepository addressRepository) {
		this.userRepository = userRepository;
		this.addressRepository = addressRepository;
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
			// Create and save Address Request
			AddressEntity savedAddress = this.addressRepository.save(userRequest.getAddress().toEntity(user));
			// Set the saved address back to the user
			user.setAddress(savedAddress);
			UserEntity updatedUser = this.userRepository.save(user);
			return updatedUser;

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
		// Validate that user exists
		UserEntity foundUser = this.userRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("User not found"));

		// Validate if username already exists then throw error
		if (!Objects.equals(foundUser.getUsername(), req.getUsername())) {
			if (this.userRepository.existsByUsername(req.getUsername())) {
				throw new AlreadyExistException("Username already exists!");
			}
		}

		// Prepare data
		foundUser.setUsername(req.getUsername());

		if (req.getAddress() == null) {
			foundUser.setAddress(null);
		} else {
			AddressEntity newAddress = req.getAddress().toEntity(foundUser);
			AddressEntity existingAddress = addressRepository.findByUserId(foundUser.getId());

			if (existingAddress != null) {
				// Update the existing address
				AddressEntity addressEntity = existingAddress;
				addressEntity.setAddress(newAddress.getAddress());
				foundUser.setAddress(addressEntity);
			} else {
				// Set the new address
				foundUser.setAddress(newAddress);
			}
		}

		try {
			// Save user entity
			return this.userRepository.save(foundUser);
		} catch (DataIntegrityViolationException ex) {
			// Handle the exception for unique constraint violation
			throw new AlreadyExistException("An address already exists for this user.");
		} catch (Exception ex) {
			throw new Exception(ex);
		}
	}
}
