package com.djcps.boot.commons.config;

import com.djcps.boot.commons.redis.RedisClientCluster;
import com.djcps.boot.commons.redis.RedisClientSingle;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * redis 配置
 * @author Chengw
 * @create 2018/3/15 16:53.
 * @since 1.0.0
 */
@Configuration
@ConditionalOnClass({JedisCluster.class})
public class RedisConfig {

    private Logger logger = LoggerFactory.getLogger(RedisConfig.class);

    @Resource
    RedisProperties redisProperties;

    @Value("${spring.redis.cluster.so-timeout}")
    private Integer soTimeout;

    @Value("${spring.redis.cluster.connection-timeout}")
    private Integer connectionTimeout;

    @Value("${spring.redis.cluster.password}")
    private String clusterPassword;

    @Value("${spring.redis.cluster.max-attempts}")
    private Integer maxAttempts;

    @Bean
    JedisPool jedisPool(){
        JedisPool jedisPool =new JedisPool(genericObjectPoolConfig(),redisProperties.getUrl());
        return jedisPool;
    }

    @Bean
    GenericObjectPoolConfig genericObjectPoolConfig(){
        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
        genericObjectPoolConfig.setMaxTotal(redisProperties.getJedis().getPool().getMaxActive());
        genericObjectPoolConfig.setMaxIdle(redisProperties.getJedis().getPool().getMaxIdle());
        genericObjectPoolConfig.setMinIdle(redisProperties.getJedis().getPool().getMinIdle());
        return genericObjectPoolConfig;
    }

    @Bean
    JedisCluster jedisCluster(){
        Set<HostAndPort> hostAndPortSet = new HashSet<>();
        redisProperties.getCluster().getNodes().forEach(
                a -> {
                    String[] str = a.split(":");
                    String host = str[0];
                    Integer port = Integer.valueOf(str[1]);
                    hostAndPortSet.add(new HostAndPort(host,port));
                }
        );

        return new JedisCluster(hostAndPortSet,connectionTimeout,soTimeout,maxAttempts,clusterPassword,genericObjectPoolConfig());
    }

    @Bean
    RedisClientSingle redisClientSingle(){
        return new RedisClientSingle();
    }

    @Bean
    RedisClientCluster redisClientCluster(){
        return new RedisClientCluster();
    }


}
