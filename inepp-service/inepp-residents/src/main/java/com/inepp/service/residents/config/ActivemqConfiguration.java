package com.inepp.service.residents.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

/**
 * @ClassName: ActivemqConfiguration
 * @Author
 * @Date 2022/4/4
 */
@Configuration
public class ActivemqConfiguration {

    @Bean
    public Queue queue(){
        return new ActiveMQQueue("active.queue");
    }
}
