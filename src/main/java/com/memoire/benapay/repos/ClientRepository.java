package com.memoire.benapay.repos;

import org.springframework.data.repository.CrudRepository;

import com.memoire.benapay.model.Client;

public interface ClientRepository extends CrudRepository<Client, Integer> {
    
}

