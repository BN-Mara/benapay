package com.memoire.benapay.repos;

import org.springframework.data.repository.CrudRepository;

import com.memoire.benapay.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    
}
