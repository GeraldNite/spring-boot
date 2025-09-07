package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Message;


@RestController
public class MessageController {

    @RequestMapping("/hello")
    
    public Message sayHello(){
        return new Message("Hello World");
    }
}
