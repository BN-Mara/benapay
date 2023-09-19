package com.memoire.benapay.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memoire.benapay.model.Account;
import com.memoire.benapay.repos.AccountReository;
import com.memoire.benapay.utils.AppDateTime;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {

    @Autowired
    private AccountReository repository;

    public Account create(Account account){
        return repository.save(account);
    }
    public Iterable<Account> get(){
        return repository.findAll();
    }
    public Account get(int id){
        var op = repository.findById(id);
        if (op.isPresent()) {
            return op.get();
            
        }else{
            return null;
        }
    }
    public Account update(Account account){
        account.setUpdatedAt(AppDateTime.now());
        return repository.save(account);
    }
    public void delete(int id){
        repository.deleteById(id);
    }
}
