package com.example.demo;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author ：ZhangYi
 * @date ：Created in 2021/5/26 8:58
 * @description：
 * @modified By：
 * @version:
 */


@Component
@RabbitListener(queues = "TestDirectQueue")
public class DirectReceiver {
    @RabbitHandler
    public void process(Map testMessage){
        System.out.println("收到消息:"+testMessage.toString());
    }
}
