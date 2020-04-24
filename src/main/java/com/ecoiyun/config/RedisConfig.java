/**
 * 
 */
package com.ecoiyun.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Administrator
 *
 */
@ConfigurationProperties("application.properties")
@Configuration
public class RedisConfig {
	@Value("${spring.redis.hostName}")
	private String hostName;
	@Value("${spring.redis.port}")
	private Integer port;

	@Bean
	public RedisConnectionFactory redisConnectionFactory() {
		JedisConnectionFactory cFactory = new JedisConnectionFactory();
		cFactory.setHostName(hostName);
		cFactory.setPort(port);
		cFactory.afterPropertiesSet();
		return cFactory;
	}

	@Bean
	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
		StringRedisTemplate template = new StringRedisTemplate();
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		ObjectMapper oMapper = new ObjectMapper();
		oMapper.setVisibility(PropertyAccessor.ALL,  JsonAutoDetect.Visibility.ANY);
		oMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(oMapper);
		template.setValueSerializer(jackson2JsonRedisSerializer);
		template.afterPropertiesSet();
		return template;
	}
}
