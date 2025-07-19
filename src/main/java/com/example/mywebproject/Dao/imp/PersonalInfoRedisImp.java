package com.example.mywebproject.Dao.imp;

import com.example.mywebproject.Dao.PersonalInfoRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Repository
public class PersonalInfoRedisImp implements PersonalInfoRedis {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @Override
    public String setUUID(Integer id) {
        UUID uuid = UUID.randomUUID();
        redisTemplate.opsForValue().set(id.toString() + "second", uuid.toString(),240, TimeUnit.HOURS);
        return uuid.toString();
    }

    @Override
    public String getUUID(Integer id) {
        return redisTemplate.opsForValue().get(id.toString() + "second");
    }
}
