package com.jn.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping({"/" , "/index.html"})
    public String login() {
        return "index";
    }

    @RequestMapping("/hello")
    public String hello(Map<String,Object> map) {
        map.put("hello", "你好啊");
        map.put("users", Arrays.asList("a1", "b2", "c3"));
        return "hello";
    }
}
