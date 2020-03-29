package com.example.pcfredis;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class PcfRedisService {

	@Autowired
	RedisConnectionFactory myRedisConnectionFactory;

	StringRedisTemplate redisTemplate;

	public String getValue(String key) {
		return redisTemplate.opsForValue().get(key);
	}

	public boolean setValue(Map<String, String> keyValue) {
		keyValue.forEach((key, value) -> redisTemplate.opsForValue().set(key, value));
		return true;
	}

	@PostConstruct
	public void init() {
		redisTemplate = new StringRedisTemplate(myRedisConnectionFactory);
	}
}
