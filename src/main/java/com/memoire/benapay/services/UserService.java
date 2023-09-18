package com.memoire.benapay.services;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memoire.benapay.model.User;
import com.memoire.benapay.repos.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository repository;

    public User create(User user){
       return repository.save(user);
    }
    public Iterable<User> get(){
        return repository.findAll();
    }
    public User get(int id){
        var op = repository.findById(id);
        if(op.isPresent()){
            return op.get();
        }
        else{
            return null;
        }
    }

    public User update(User user){
        return repository.save(user);
    }
}
