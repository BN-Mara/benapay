package com.memoire.benapay.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memoire.benapay.dto.AccountDto;
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
        //var account = new Account();
        //account.setUser(account2.getUser());
        //account.setBalance(account2.getBalance());
        //account.setBalance(account2.getBalance());
        account.setCreatedAt(AppDateTime.now());
        account.setUpdatedAt(null);
        //account.setCurrency(account2.getCurrency());
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
