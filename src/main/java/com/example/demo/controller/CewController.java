package com.example.demo.controller;

import org.springframework.stereotype.Controller;

import com.example.demo.service.CewService;

@Controller
public class CewController {
    private final CewService service;

    public CewController(CewService service) {
        this.service = service;
    }

}
