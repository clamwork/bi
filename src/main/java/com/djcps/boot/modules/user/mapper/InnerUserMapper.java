package com.djcps.boot.modules.user.mapper;

import com.djcps.boot.modules.user.model.InnerUserPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Chengw
 * @create 2018/3/15 10:43.
 * @since 1.0.0
 */
@Mapper
public interface InnerUserMapper {

    /**
     *
     * @return
     */
    List<InnerUserPO> findAll();
}
