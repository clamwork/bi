package com.djcps.boot.modules.user.service.impl;

import com.djcps.boot.commons.redis.RedisClientSingle;
import com.djcps.boot.commons.server.NumberServer;
import com.djcps.boot.modules.user.dao.UserRedisDao;
import com.djcps.boot.modules.user.mapper.InnerUserMapper;
import com.djcps.boot.modules.user.model.InnerUserPO;
import com.djcps.boot.modules.user.service.InnerUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Chengw
 * @create 2018/3/15 10:54.
 * @since 1.0.0
 */
@Service
@Transactional(rollbackFor = {Exception.class})
public class InnerUserServiceImpl implements InnerUserService {

    @Autowired
    private InnerUserMapper innerUserMapper;

    @Autowired
    private NumberServer numberServer;

    @Autowired
    private UserRedisDao userRedisDao;


    @Override
    public List<InnerUserPO> findAll() {
        List<InnerUserPO> result = innerUserMapper.findAll();
        userRedisDao.setUserList(result);
        return result;
    }

    @Override
    public List<InnerUserPO> findAllByRedis() {
        return userRedisDao.list();
    }

    @Override
    public String getNumber() {
        return numberServer.getNumber(1);
    }
}
