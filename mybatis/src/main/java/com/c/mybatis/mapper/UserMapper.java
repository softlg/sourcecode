package com.c.mybatis.mapper;


import com.c.mybatis.entity.User;

public interface UserMapper {
    User selectById(Integer id);
}
