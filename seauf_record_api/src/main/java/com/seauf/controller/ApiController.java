package com.seauf.controller;

import entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: lynn
 * @create: 2019/02/21
 */
@RestController
@RequestMapping("api")
public class ApiController {

    @GetMapping("userInfo")
    public User userInfo(){
        User user = new User();
        user.setName("test");
        return user;
    }

}
