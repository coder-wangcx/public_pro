package com.team.house_backapi.service;

import com.team.house_backapi.entity.Users;

public interface UserService {
    //登录
    Users login(String username, String password);

    //注册
    int regist(Users users);
}
