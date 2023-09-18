package com.memoire.benapay.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memoire.benapay.model.Role;
import com.memoire.benapay.repos.RoleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleService {
    @Autowired
    private RoleRepository repository;

    public Role create(Role role){
        return repository.save(role);
    }
    public Iterable<Role> fetch(){
        return repository.findAll();
    }
    public Role fetch(int id){
        var op = repository.findById(id);
        if(op.isPresent()){
            return op.get();
        }
        else{
            return null;
        }
    }
    public Role update(Role role){
        return repository.save(role);

    }
    public void delete(int id){
        repository.deleteById(id);
    }

    
}
