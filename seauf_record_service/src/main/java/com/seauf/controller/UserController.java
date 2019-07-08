package com.seauf.controller;

import com.alibaba.fastjson.JSON;
import com.seauf.controller.vo.UserVO;
import com.seauf.entity.User;
import com.seauf.service.UserService;
import com.seauf.service.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: lynn
 * @create: 2019/02/21
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("login")
    public String index() {
        return "user/login";
    }

    @PostMapping("register")
    @ResponseBody
    public Integer register(@RequestBody UserVO userVO, HttpServletRequest req) {
//        stringRedisTemplate.opsForValue().set("users", JSON.toJSONString(users));
        try {
            req.getInputStream();

        } catch (IOException e) {
            e.printStackTrace();
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(userVO.getUserName());
        return userService.insert(userDTO);
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

    @RequestMapping("test")
    public String test() {
        return "test";
    }


}
