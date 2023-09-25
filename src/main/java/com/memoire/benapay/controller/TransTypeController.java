package com.memoire.benapay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.memoire.benapay.model.TransType;
import com.memoire.benapay.services.TransTypeService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/api/transTypes")
@RestController
@RequiredArgsConstructor
public class TransTypeController {
    @Autowired
    private TransTypeService service;

    @PostMapping
    public TransType create(@RequestBody TransType transType){
        return service.create(transType);
    }
    @GetMapping
    public Iterable<TransType> fetch(){
        return service.get();
    }

}
