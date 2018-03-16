package com.djcps.boot.modules.user.dao;

import com.alibaba.fastjson.JSONObject;
import com.djcps.boot.commons.redis.RedisClientCluster;
import com.djcps.boot.commons.redis.RedisClientSingle;
import com.djcps.boot.modules.user.constant.UserRedisConstant;
import com.djcps.boot.modules.user.model.InnerUserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chengw
 * @create 2018/3/15 17:20.
 * @since 1.0.0
 */
@Component
public class UserRedisDao {

    @Autowired
    RedisClientCluster redisClientCluster;

    /**
     * 设置用户查询列表
     * @param list
     * @return
     */
    public Boolean setUserList(List<InnerUserPO> list){
        Long result = redisClientCluster.setnx(UserRedisConstant.USER_REDIS_CONNECT, JSONObject.toJSONString(list));
        if(result > 0){
            redisClientCluster.expire(UserRedisConstant.USER_REDIS_CONNECT,UserRedisConstant.TEN_MIN);
            return true;
        }
        return false;
    }

    /**
     * 返回列表
     * @return
     */
    public List<InnerUserPO> list(){
        String json = redisClientCluster.get(UserRedisConstant.USER_REDIS_CONNECT);
        List<InnerUserPO> result = new ArrayList<>();
        if(!StringUtils.isEmpty(json)){
            result = JSONObject.parseArray(json,InnerUserPO.class);
        }
        return result;

    }
}
