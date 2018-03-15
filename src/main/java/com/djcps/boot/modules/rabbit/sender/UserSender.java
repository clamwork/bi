package com.djcps.boot.modules.rabbit.sender;

import com.djcps.boot.commons.msg.MsgTemplate;
import com.djcps.boot.modules.rabbit.constant.RabbitQueueConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


/**
 * @author Chengw
 * @create 2018/3/15 15:15.
 * @since 1.0.0
 */
@Component
public class UserSender {

    private Logger logger = LoggerFactory.getLogger(UserSender.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send() {
        String context = "hello " + LocalDateTime.now().toString();
        logger.info("sender : {} ", context);
        amqpTemplate.convertAndSend(RabbitQueueConstant.USER_QUEUE,context);
        amqpTemplate.convertAndSend(RabbitQueueConstant.USER_QUEUE_2, MsgTemplate.successMsg(context));
    }

}
