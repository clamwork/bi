package com.djcps.boot.modules.rabbit.receiver;

import com.alibaba.fastjson.JSONObject;
import com.djcps.boot.modules.rabbit.constant.RabbitQueueConstant;
import com.djcps.log.DjcpsLogger;
import com.djcps.log.DjcpsLoggerFactory;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @author Chengw
 * @create 2018/3/15 15:09.
 * @since 1.0.0
 */
@Component
public class UserReceiver{

    private DjcpsLogger logger = DjcpsLoggerFactory.getLogger(UserReceiver.class);

    /**
     * FANOUT广播队列监听一.
     *
     * @param message the message
     * @param channel the channel
     * @throws IOException the io exception  这里异常需要处理
     */
    @RabbitListener(queues = {"user.fanout.queue.a"})
    public void on(Message message, Channel channel) throws IOException {
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        logger.debug("FANOUT_QUEUE_A {} " , new String(message.getBody()));
    }

    /**
     * FANOUT广播队列监听二.
     *
     * @param message the message
     * @param channel the channel
     * @throws IOException the io exception   这里异常需要处理
     */
    @RabbitListener(queues = {"user.fanout.queue.b"})
    public void t(Message message, Channel channel) throws IOException {
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        logger.debug("FANOUT_QUEUE_B {} " , new String(message.getBody()));
    }

    /**
     * DIRECT模式.
     *
     * @param message the message
     * @param channel the channel
     * @throws IOException the io exception  这里异常需要处理
     */
    @RabbitListener(queues = {RabbitQueueConstant.USER_QUEUE,RabbitQueueConstant.USER_QUEUE_2})
    public void message(Message message, Channel channel) throws IOException {
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        logger.debug("user {} " , new String(message.getBody()));
    }
}
