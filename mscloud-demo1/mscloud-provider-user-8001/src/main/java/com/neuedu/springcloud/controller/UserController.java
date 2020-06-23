package com.neuedu.springcloud.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neuedu.springcloud.domain.User;
import com.neuedu.springcloud.service.UserServiceImpl;


@RestController
@RequestMapping("/user")
public class UserController {

    // 注入UserService
    @Resource
    private UserServiceImpl userService;

    @RequestMapping("/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }

    @RequestMapping("/findUserById/{id}")
    public User findUserById(@PathVariable("id") int id) {

        return userService.findUserById(id);
    }
}
