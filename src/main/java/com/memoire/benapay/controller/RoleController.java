package com.memoire.benapay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.memoire.benapay.model.Role;
import com.memoire.benapay.services.RoleService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/api/roles")
@RestController
@RequiredArgsConstructor
public class RoleController {
    @Autowired
    private RoleService service;

    @PostMapping
    public Role create(@RequestBody Role role){
        return service.create(role);
    }
    @GetMapping
    public Iterable<Role> fetch(){
        return service.fetch();
    }
    @GetMapping("/{id}")
    public Role fetch(@PathVariable int id) {
        return service.fetch(id);
    }
    

}
