package com.ywf.srpingbootproject.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ywf.srpingbootproject.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserPlusMapper extends BaseMapper<User> {
    List<User> findUserList();
}
