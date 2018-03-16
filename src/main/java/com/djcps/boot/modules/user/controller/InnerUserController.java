package com.djcps.boot.modules.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.djcps.boot.commons.aop.log.annotation.AddLog;
import com.djcps.boot.commons.config.ParamsConfig;
import com.djcps.boot.modules.rabbit.sender.UserSender;
import com.djcps.boot.modules.user.model.InnerUserPO;
import com.djcps.boot.modules.user.service.InnerUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import static com.djcps.boot.commons.msg.MsgTemplate.*;

/**
 * @author Chengw
 * @create 2018/3/15 10:18.
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "user/inner")
public class InnerUserController {

    private Logger logger = LoggerFactory.getLogger(InnerUserController.class);

    @Autowired
    private InnerUserService innerUserService;

    @Autowired
    private UserSender userSender;

    @Autowired
    private ParamsConfig paramsConfig;

    @AddLog(module = "内部用户",value = "该接口用于获取用户信息列表")
    @RequestMapping(value = "list",method = {RequestMethod.GET,RequestMethod.POST})
    public Map<String,Object> list() throws Exception{
        logger.info("list param");
        List<InnerUserPO> list = innerUserService.findAll();
        return successMsg(list);
    }

    @RequestMapping(value = "listByRedis",method = {RequestMethod.GET,RequestMethod.POST})
    public Map<String,Object> listByRedis() throws Exception{
        logger.info("redis list param");
        List<InnerUserPO> list = innerUserService.findAllByRedis();
        return successMsg(list);
    }

    @RequestMapping(value = "msg",method = {RequestMethod.GET,RequestMethod.POST})
    public Map<String,Object> msg() throws Exception{
        logger.info("msg listen");
        userSender.send();
        return successMsg();
    }

    @RequestMapping(value = "config",method = {RequestMethod.GET,RequestMethod.POST})
    public Map<String,Object> config() throws Exception{
        logger.info("paramsConfig : {}", JSONObject.toJSONString(paramsConfig));
        return successMsg(paramsConfig);
    }
}
