package com.memoire.benapay.repos;

import org.springframework.data.repository.CrudRepository;

import com.memoire.benapay.model.TransType;

public interface TransTypeRepository extends CrudRepository<TransType, Integer> {

    com.memoire.benapay.services.TransTypeService save(com.memoire.benapay.services.TransTypeService user);
    
}
