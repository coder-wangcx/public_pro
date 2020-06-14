package com.team.house_backapi.service.impl;

import com.team.house_backapi.entity.Users;
import com.team.house_backapi.entity.UsersExample;
import com.team.house_backapi.mapper.UsersMapper;
import com.team.house_backapi.service.UserService;
import com.team.house_backapi.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    private UsersMapper usersMapper;
    @Override
    public Users login(String username, String password) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        String md5Encrypt = MD5Utils.md5Encrypt(password);
        criteria.andNameEqualTo(username);
        criteria.andPasswordEqualTo(md5Encrypt);
        List<Users> list = usersMapper.selectByExample(usersExample);
        if (list!=null&&list.size()!=0){
            return list.get(0);     //返回一条用户信息
        }
        return null;
    }

    @Override
    //用户注册  添加
    public int regist(Users users) {
        //MD5加密
        users.setPassword(MD5Utils.md5Encrypt(users.getPassword()));
        return usersMapper.insertSelective(users);
    }
}
