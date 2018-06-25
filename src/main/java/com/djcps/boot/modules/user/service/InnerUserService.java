package com.djcps.boot.modules.user.service;

import com.djcps.boot.modules.user.model.InnerUserPO;

import java.util.List;

/**
 * @author Chengw
 * @since 2018/3/15 10:53.
 * @version 1.0.0
 */
public interface InnerUserService {

    /**
     * 获取所有内部用户
     * @return
     */
    List<InnerUserPO> findAll();

    /**
     * 获取所有内部用户
     * redis
     * @return
     */
    List<InnerUserPO> findAllByRedis();

    /**
     * 获取随机编码
     * @return
     */
    String getNumber();
}
