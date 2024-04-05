package com.nsdl.kra.controller;

import com.nsdl.kra.model.dto.RedisRequest;
import com.nsdl.kra.model.dto.RedisSetRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    public RedisTemplate<String, String> redisTemplate;  // Auto config usage

    @Autowired
    public Jedis jedis;

    @PostMapping()
    public String setRedisKey(@RequestBody RedisSetRequest redisSetRequest) {
        String status = null;
        try {
            status = jedis.set(redisSetRequest.getKey(), redisSetRequest.getValue());
          //  redisTemplate.opsForValue().set(redisSetRequest.getKey(),redisSetRequest.getKey());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    
    @GetMapping()
    public String getRedisKey(@RequestBody RedisRequest redisRequest) {
        String value = null;
        try {
            value = jedis.get(redisRequest.getKey());
          //  value = redisTemplate.opsForValue().get(redisRequest.getKey());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
}
