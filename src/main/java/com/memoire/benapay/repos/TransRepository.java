package com.memoire.benapay.repos;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import com.memoire.benapay.model.Transaction;

public interface TransRepository extends JpaRepository<Transaction, Integer> {

    Transaction findByReference(String reference);
    
}

