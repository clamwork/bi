package com.djcps.boot.modules.user.service;

import com.djcps.boot.modules.user.model.InnerUserPO;

import java.util.List;

/**
 * @author Chengw
 * @create 2018/3/15 10:53.
 * @since 1.0.0
 */
public interface InnerUserService {

    List<InnerUserPO> findAll();
}
