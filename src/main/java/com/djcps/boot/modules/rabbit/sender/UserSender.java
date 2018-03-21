package com.djcps.boot.modules.rabbit.sender;

import com.djcps.boot.commons.msg.MsgTemplate;
import com.djcps.boot.modules.rabbit.constant.RabbitQueueConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.UUID;


/**
 * @author Chengw
 * @create 2018/3/15 15:15.
 * @since 1.0.0
 */
@Component
public class UserSender {

    private Logger logger = LoggerFactory.getLogger(UserSender.class);

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void send() {
        String context = "hello " + LocalDateTime.now().toString();
        logger.info("sender : {} ", context);
        direct(context);
    }

    /**
     * 测试广播模式.
     *
     * @param p the p
     * @return the response entity
     */
    public void broadcast(String p) {
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend("FANOUT_EXCHANGE", "", p, correlationData);
    }

    /**
     * 测试Direct模式.
     *
     * @param p the p
     * @return the response entity
     */
    public void direct(String p) {
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend("USER_EXCHANGE", "USER_ROUTING_KEY", p, correlationData);
    }


}
