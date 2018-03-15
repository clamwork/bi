package com.djcps.boot.modules.user.controller;

import com.djcps.boot.modules.user.model.InnerUserPO;
import com.djcps.boot.modules.user.service.InnerUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "list",method = {RequestMethod.GET,RequestMethod.POST})
    public Map<String,Object> list() throws Exception{
        logger.info("list param");
        Map<String,Object> map = new HashMap(4);
        List<InnerUserPO> list = innerUserService.findAll();
        map.put("data",innerUserService.findAll());
        return map;
    }
}
