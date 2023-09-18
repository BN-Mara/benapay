package com.memoire.benapay.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/main")

public class MainController {
    
    @GetMapping
    public String getResponse(){
        return "new string for API";

    }

    
}
