package com.neuedu.springcloud.controller;

import com.neuedu.springcloud.domain.User;
import com.neuedu.springcloud.service.UserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController_Consumer {

    @Autowired
    private UserClientService clientServiceservice;

    @RequestMapping("/consumer/user/findAll")
    public List<User> findAll(){
        return clientServiceservice.findAll();
    }

    @RequestMapping("/consumer/user/findUserById/{id}")
    public User findUserById(@PathVariable("id") int id){

        return clientServiceservice.findUserById(id);
    }
}