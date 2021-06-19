package com.example.uniontestdemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：ZhangYi
 * @date ：Created in 2021/6/19 20:19
 * @description：
 * @modified By：
 * @version:
 */
@RequestMapping("/demo")
@RestController
public class DemoController {


    @RequestMapping()
    public String test(){
        return "hello world";
    }
}
