package com.seauf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: lynn
 * @create: 2019/04/04
 */
@Controller
@RequestMapping(value = {"home"})
public class HomeController {

    @RequestMapping("console")
    public String console() {
        return "home/console";
    }
}
