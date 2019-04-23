package com.seauf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Stack;

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
}
