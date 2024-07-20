package com.vn.learn_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vn.learn_springboot.model.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

	
}
