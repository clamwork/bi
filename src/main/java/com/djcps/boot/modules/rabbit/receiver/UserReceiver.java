package com.djcps.boot.modules.rabbit.receiver;

import com.alibaba.fastjson.JSONObject;
import com.djcps.boot.modules.rabbit.constant.RabbitQueueConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Chengw
 * @create 2018/3/15 15:09.
 * @since 1.0.0
 */
@Component
@RabbitListener(queues = {RabbitQueueConstant.USER_QUEUE,RabbitQueueConstant.USER_QUEUE_2})
public class UserReceiver{

    private Logger logger = LoggerFactory.getLogger(UserReceiver.class);

    /**
     * 字符串的消息处理
     * @param msg
     */
    @RabbitHandler
    public void process(String msg){
        logger.info("String : {}",msg);
    }

    /**
     * map的消息处理
     * @param map
     */
    @RabbitHandler
    public void process(Map map){
        logger.info("map : {}",JSONObject.toJSONString(map));
    }
}
