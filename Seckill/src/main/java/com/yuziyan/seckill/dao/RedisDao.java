package com.yuziyan.seckill.dao;

import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class RedisDao {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    //从redis获取数据
    public Object get(String key) {
        if (StrUtil.isEmpty(key)) {
            return null;
        }
        return redisTemplate.opsForValue().get(key);
    }

    //存数据
    public boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    /**
     * 存数据（设置超时）
     *
     * @param key
     * @param value
     * @param time  超时时间（秒）
     * @return
     */
    public boolean set(String key, Object value, long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                this.set(key, value);

            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
