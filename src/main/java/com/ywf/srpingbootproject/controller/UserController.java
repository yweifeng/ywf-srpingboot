package com.ywf.srpingbootproject.controller;

import com.github.pagehelper.Page;
import com.ywf.srpingbootproject.entity.User;
import com.ywf.srpingbootproject.service.IUserService;
import com.ywf.srpingbootproject.util.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api(value = "用户控制层",tags = {"用户操作"})
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/getUser/{id}")
    @ApiOperation(value = "获取用户详情",notes = "根据用户id获取用户详情")
    public User getUser(@PathVariable int id) {
        User user = userService.getUser(id);
        return user;
    }

    @RequestMapping("/insertUser")
    public String inserUser(@RequestParam String username) {
        userService.insertUser(username);
        return username + " insert success";
    }

    @ApiOperation(value = "获取用户列表",notes = "获取用户列表")
    @RequestMapping("/findUserList")
    public List<User> findUserList() {
        return userService.findUserList();
    }

    @ApiOperation(value = "分页获取用户列表",notes = "分页获取用户列表")
    @RequestMapping("/findPageUserList")
    public Page<User> findPageUserList(@RequestParam int pageNum, @RequestParam int pageSize) {
        return userService.findPageUserList(pageNum, pageSize);
    }

    @ApiOperation(value = "插入到redis",notes = "插入到redis")
    @RequestMapping("/insert2Redis")
    public String insert2Redis(@RequestParam String key, @RequestParam String value) {
        redisUtil.set(key, value);
        return "success";
    }

    @ApiOperation(value = "根据key从redis中获取",notes = "根据key从redis中获取")
    @RequestMapping("/getFromRedis/{key}")
    public String getFromRedis(@PathVariable String key) {
        return (String) redisUtil.get(key);
    }
}
