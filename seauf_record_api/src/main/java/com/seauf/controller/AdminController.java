package com.seauf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: lynn
 * @create: 2019/02/21
 */
@Controller
@RequestMapping("admin")
public class AdminController {

    @RequestMapping("test")
    public String userInfo(){
        return "test";
    }

}
