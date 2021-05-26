package com.example.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：ZhangYi
 * @date ：Created in 2021/5/26 9:02
 * @description：
 * @modified By：
 * @version:
 */
@Configuration
public class DirectRabbitConfig {

    @Bean
    public Queue TestDirectQueue(){
        return new Queue("TestDirectQueue",true);
    }

    @Bean
    DirectExchange TestDirectExchange(){
        return new DirectExchange("TestDirectExchange",true,false);
    }

    @Bean
    Binding bindingDirect(){
        return BindingBuilder.bind(TestDirectQueue()).to(TestDirectExchange()).with("TestDirectRouting");
    }

    @Bean
    DirectExchange lonelyDirectExchange(){
        return new DirectExchange("lonelyDirectExchange");
    }
}
