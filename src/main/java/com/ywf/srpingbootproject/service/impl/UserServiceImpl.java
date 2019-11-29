package com.ywf.srpingbootproject.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ywf.srpingbootproject.dao.UserMapper;
import com.ywf.srpingbootproject.dao.UserPlusMapper;
import com.ywf.srpingbootproject.entity.User;
import com.ywf.srpingbootproject.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserPlusMapper userPlusMapper;

    @Override
    public User getUser(int id) {
        return userMapper.getUser(id);
    }

    @Override
//    @Transactional(rollbackFor = Exception.class)
    public void insertUser(String username) {
        User u = new User();
        u.setUser_name(username);
        u.setUser_password("1");
        userMapper.insertUser(u);
        // 测试异常
        int i = 1/0;
    }

    @Override
    public List<User> findUserList() {
        return userPlusMapper.findUserList();
    }

    @Override
    public Page<User> findPageUserList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<User> records = userMapper.findUserList();
        return records;
    }
}
