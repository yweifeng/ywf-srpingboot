package com.ywf.srpingbootproject.dao;

import com.github.pagehelper.Page;
import com.ywf.srpingbootproject.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    User getUser(int id);

    void insertUser(User u);

    @Select("SELECT * FROM USER")
    Page<User> findUserList();
}
