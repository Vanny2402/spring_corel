package com.jv.crud_operation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jv.crud_operation.model.entity.AddressEntity;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity,Long> {

}
