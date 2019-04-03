package com.seauf.controller;

import com.alibaba.fastjson.JSON;
import entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: lynn
 * @create: 2019/02/21
 */
@RestController
@RequestMapping("api")
public class ApiController {

    private Logger logger =  LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("userInfo")
    public User userInfo(HttpServletRequest req){
        User user = new User();
        user.setName("lynn");
        List<User> users = new ArrayList<>();
        users.add(user);
        stringRedisTemplate.opsForValue().set("users", JSON.toJSONString(users));
        return user;
    }

}
