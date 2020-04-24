/**
 * 
 */
package com.ecoiyun.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecoiyun.entity.Department;
import com.ecoiyun.entity.User;
import com.ecoiyun.redis.UserRedis;

/**
 * @author Administrator
 *
 */
@Controller
public class UserController {
    @Autowired
    UserRedis userRedis;
    
    @RequestMapping("/user/testRedisSave")
    public String testRedis() {
        Department department=new Department();
        department.setName("开发部");
        Role role=new Role();
        ((User) role).setName("admin");
        User user=new User();
        user.setName("hlhdidi");
        user.setCreateDate(new Date());
        user.setDepartment(department);
        Set<Role> roles=new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        userRedis.delete(this.getClass().getName()+":username:"+user.getName());
        userRedis.add(this.getClass().getName()+":username:"+user.getName(), user);
        return null;
    }
    @RequestMapping("/user/testRedisGet")
    public String testRedis2() {
        User user=userRedis.get(this.getClass().getName()+":username:hlhdidi");
        System.out.println(user);
        return null;
    }
}
