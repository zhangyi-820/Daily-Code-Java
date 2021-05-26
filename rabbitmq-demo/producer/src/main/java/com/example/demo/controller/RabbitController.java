package com.example.demo.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.UUID;

/**
 * @author ：ZhangYi
 * @date ：Created in 2021/5/26 9:03
 * @description：
 * @modified By：
 * @version:
 */
@RestController
public class RabbitController {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("/sendDirectMessage")
    public String sendDirectMessage(){
        String messageId=String.valueOf(UUID.randomUUID());
        String messageData="test message,hello!";
        String createTime= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        HashMap<String,Object> map=new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",messageData);
        map.put("createTime",createTime);

        rabbitTemplate.convertAndSend("TestDirectExchange","TestDirectRouting",map);
        return "ok";
    }
}
