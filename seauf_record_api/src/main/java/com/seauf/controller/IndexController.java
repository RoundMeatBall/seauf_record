package com.seauf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: lynn
 * @create: 2019/04/04
 */
@Controller
public class IndexController {

    @RequestMapping("")
    public String index() {
        return "index";
    }

    @RequestMapping("nav")
    public String nav() {
        return "nav";
    }

    @RequestMapping("head")
    public String head() {
        return "head";
    }

    @RequestMapping("foot")
    public String foot() {
        return "foot";
    }

    @RequestMapping("/index/dashboard")
    public String dashboard() {
        return "/index/dashboard";
    }
}
