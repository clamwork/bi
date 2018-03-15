package com.djcps.boot.modules.user.service.impl;

import com.djcps.boot.modules.user.mapper.InnerUserMapper;
import com.djcps.boot.modules.user.model.InnerUserPO;
import com.djcps.boot.modules.user.service.InnerUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Chengw
 * @create 2018/3/15 10:54.
 * @since 1.0.0
 */
@Service
public class InnserUserServiceImpl implements InnerUserService {

    @Autowired
    InnerUserMapper innerUserMapper;

    @Override
    public List<InnerUserPO> findAll() {
        return innerUserMapper.findAll();
    }
}
