/**
 * 
 */
package com.ecoiyun.redis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.ecoiyun.entity.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author Administrator
 *
 */
@Repository
public class UserRedis {
	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	public void add(String key, User user) {
		Gson gson = new Gson();
		redisTemplate.opsForValue().set(key, gson.toJson(user));
	}

	public void add(String key, List<User> users) {
		Gson gson = new Gson();
		redisTemplate.opsForValue().set(key, gson.toJson(users));
	}

	public User get(String key) {
		Gson gson = new Gson();
		User user = null;
		String userStr = redisTemplate.opsForValue().get(key);
		if (!StringUtils.isEmpty(userStr))
			user = gson.fromJson(userStr, User.class);
		return user;
	}

	public List<User> getList(String key) {
		Gson gson = new Gson();
		List<User> users = null;
		String listJson = redisTemplate.opsForValue().get(key);
		if (!StringUtils.isEmpty(listJson)) {
			users = gson.fromJson(listJson, new TypeToken<List<User>>() {
			}.getType());
		}
		return users;
	}

	public void delete(String key) {
		redisTemplate.opsForValue().getOperations().delete(key);
	}
}
