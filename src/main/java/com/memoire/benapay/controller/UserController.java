package com.memoire.benapay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.memoire.benapay.model.User;
import com.memoire.benapay.services.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping
    public User create(@RequestBody  User user){
        return service.create(user);
    }

    @GetMapping
    public Iterable<User> fetch(){
        return service.get();
    }
    
    @GetMapping("/{id}")
    public User fetch( @PathVariable int id){
        return service.get(id);
    }

    //Benji will include update

    @PutMapping
    public User update(@RequestBody User user){
        return service.update(user);
    }
}
