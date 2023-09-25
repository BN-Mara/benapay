package com.memoire.benapay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.memoire.benapay.dto.AccountDto;
import com.memoire.benapay.model.Account;
import com.memoire.benapay.services.AccountService;
import com.memoire.benapay.utils.AppDateTime;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {

    
    @Autowired
    private AccountService service;

    @PostMapping
    public Account create(@RequestBody Account account){
       // account.setCreatedAt(AppDateTime.now());
        //account.setUpdatedAt(null);

        return service.create(account);
    }

    @GetMapping
    public Iterable<Account> fetch(){
        return service.get();
    }

    @GetMapping("/{id}")
    public Account fetch(@PathVariable int id){
        return service.get(id);
    }
}
