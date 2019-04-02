package com.seauf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: lynn
 * @create: 2019/02/21
 */
@Controller
@RequestMapping(value = {"admin",""})
public class AdminController {

    @RequestMapping("")
    public String index(){
        return "index";
    }

    @RequestMapping("test")
    public String userInfo(){
        return "test";
    }

    @RequestMapping("game")
    public String game(){
        return "game";
    }



}
