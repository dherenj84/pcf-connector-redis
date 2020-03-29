package com.example.pcfredis;

import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;

public class CloudConfig extends AbstractCloudConfig {

	@Bean
	public RedisConnectionFactory myRedisConnectionFactory() {
		return connectionFactory().redisConnectionFactory();
	}
}
