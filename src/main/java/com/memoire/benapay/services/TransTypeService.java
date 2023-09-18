package com.memoire.benapay.services;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memoire.benapay.model.TransType;
import com.memoire.benapay.repos.TransTypeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransTypeService {

    @Autowired
    private TransTypeRepository repository;

    public TransType create(TransType user){
       return repository.save(user);
    }
    public Iterable<com.memoire.benapay.model.TransType> get(){
        return repository.findAll();
    }
    public com.memoire.benapay.model.TransType get(int id){
        var op = repository.findById(id);
        if(op.isPresent()){
            return op.get();
        }
        else{
            return null;
        }
    }

    public TransTypeService update(TransTypeService user){
        return repository.save(user);
    }
    public void delete(int id){
        repository.deleteById(id);
    }
}
