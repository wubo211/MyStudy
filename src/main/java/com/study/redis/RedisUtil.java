package com.study.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;


/**
 * @Author: wubo
 * @Description:
 * @Date Created in 下午10:56 19/10/10
 **/
@Component
public class RedisUtil {
    @Autowired
    private JedisPool jedisPool;

    public String get(String key){
        return jedisPool.getResource().get(key);

    }

    public String set(String key,String value){
        return jedisPool.getResource().set(key,value);
    }

    public Long del(String key){
        return jedisPool.getResource().del(key);
    }



}
