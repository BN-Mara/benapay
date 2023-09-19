package com.memoire.benapay.services;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memoire.benapay.model.Transaction;
import com.memoire.benapay.repos.TransRepository;
import com.memoire.benapay.utils.AppDateTime;
import com.memoire.benapay.utils.Utils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TranService {

    @Autowired
    private TransRepository repository;

    public Transaction create(Transaction trans){
        trans.setReference(generateReference());
        trans.setDateTrans(AppDateTime.now());
       return repository.save(trans);
    }
    public Iterable<Transaction> get(){
        return repository.findAll();
    }
    public Transaction get(int id){
        var op = repository.findById(id);
        if(op.isPresent()){
            return op.get();
        }
        else{
            return null;
        }
    }

    public Transaction update(Transaction user){
        return repository.save(user);
    }
    private String generateReference(){
        var code = Utils.generateCode();
        if (repository.findByReference(code) != null) {
            generateReference();
        }
        return code;
            
        
    }
}
