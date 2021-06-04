package com.example.securitydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：ZhangYi
 * @date ：Created in 2021/6/4 10:42
 * @description：
 * @modified By：
 * @version:
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/test")
    public String test(){
        return "Hello world!";
    }
}
