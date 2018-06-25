package com.djcps.boot.modules.user.mapper;

import com.djcps.boot.modules.user.model.InnerUserPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Chengw
 * @since 2018/3/15 10:43.
 * @version 1.0.0
 */
@Mapper
public interface InnerUserMapper {

    /**
     * 获取所有内部用户
     * @return
     */
    List<InnerUserPO> findAll();
}
