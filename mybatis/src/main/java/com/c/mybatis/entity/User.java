package com.c.mybatis.entity;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String userName;
    private String pwd;
    private Integer age;
    private Integer gender;
}
