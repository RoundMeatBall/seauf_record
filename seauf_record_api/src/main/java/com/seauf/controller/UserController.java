package com.seauf.controller;

import com.alibaba.fastjson.JSON;
import entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: lynn
 * @create: 2019/02/21
 */
@Controller
@RequestMapping(value = {"user"})
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("login")
    public String index() {
        return "user/login";
    }

    @PostMapping("register ")
    public User register (HttpServletRequest req) {
        User user = new User();
        user.setName("lynn");
        List<User> users = new ArrayList<>();
        users.add(user);
        stringRedisTemplate.opsForValue().set("users", JSON.toJSONString(users));
        return user;
    }

    @PostMapping("info")
    public User userInfo(HttpServletRequest req) {
        User user = new User();
        user.setName("lynn");
        List<User> users = new ArrayList<>();
        users.add(user);
        stringRedisTemplate.opsForValue().set("users", JSON.toJSONString(users));
        return user;
    }

    @RequestMapping("game")
    public String game() {
        return "game";
    }


}
