package com.jv.crud_operation.model.entity.response.infra;

import java.io.Serializable;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity<ID extends Serializable> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ID id;
    
    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }
}
