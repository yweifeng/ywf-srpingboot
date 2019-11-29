package com.ywf.srpingbootproject.service;

import com.github.pagehelper.Page;
import com.ywf.srpingbootproject.entity.User;

import java.util.List;

public interface IUserService {
    User getUser(int id);

    void insertUser(String username);

    List<User> findUserList();

    Page<User> findPageUserList(int pageNum, int pageSize);
}
