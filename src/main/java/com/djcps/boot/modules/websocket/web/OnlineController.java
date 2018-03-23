package com.djcps.boot.modules.websocket.web;

import com.alibaba.fastjson.JSONObject;
import com.djcps.boot.commons.msg.MsgTemplate;
import com.djcps.log.DjcpsLogger;
import com.djcps.log.DjcpsLoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author Chengw
 * @create 2018/3/21 09:31.
 * @since 1.0.0
 */
@Controller
public class OnlineController {

    private static DjcpsLogger logger = DjcpsLoggerFactory.getLogger(OnlineController.class);

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/welcome")
    @SendTo("/topic/say")
    public String say(String message){
        logger.debug("message : {}",message);
        return JSONObject.toJSONString(MsgTemplate.successMsg(message));
    }

    /**
     * 定时推送消息
     */
    @Scheduled(fixedRate = 10000)
    public void callback() {
        // 发现消息
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpMessagingTemplate.convertAndSend("/topic/callback", "定时推送消息时间: " + df.format(new Date()));
    }
}
