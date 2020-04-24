/**
 * 
 */
package com.ecoiyun.hello;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/user")
public class FirstController {

	/**
	 * @param args
	 */
	@RequestMapping("/{id}")
	public User testSpringBoot(@PathVariable("id") Integer id) {
		User user = new User();
		user.setName("zhangsan");
		user.setPassword(id+"");
		System.out.println(user);
		return user;
	}
}
