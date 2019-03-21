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

    @RequestMapping(value = {"index",""})
    public String index(){
        return "index";
    }

    @RequestMapping("test")
    public String userInfo(){
        return "test";
    }



}
