package com.djcps.boot.commons.config;

import com.djcps.boot.modules.rabbit.constant.RabbitQueueConstant;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Chengw
 * @create 2018/3/15 15:03.
 * @since 1.0.0
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue userQueue(){
        return new Queue(RabbitQueueConstant.USER_QUEUE);
    }
}
