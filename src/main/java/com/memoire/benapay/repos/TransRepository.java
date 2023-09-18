package com.memoire.benapay.repos;

import org.springframework.data.repository.CrudRepository;

import com.memoire.benapay.model.Transaction;

public interface TransRepository extends CrudRepository<Transaction, Integer> {
    
}

