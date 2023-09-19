package com.memoire.benapay.repos;

import org.springframework.data.repository.CrudRepository;

import com.memoire.benapay.model.Account;

public interface AccountReository extends CrudRepository<Account,Integer> {
    
}
