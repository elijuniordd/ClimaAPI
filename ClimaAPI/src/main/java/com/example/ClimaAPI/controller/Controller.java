package com.example.ClimaAPI.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.ClimaAPI.service.Service;

@RestController
public class Controller {

    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("/clima/{cidade}")
    public String preverTempo(@PathVariable String cidade){
        return service.preverTempo(cidade);
    }
}
