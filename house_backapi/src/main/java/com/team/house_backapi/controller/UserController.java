package com.team.house_backapi.controller;

import com.team.house_backapi.entity.Users;
import com.team.house_backapi.service.UserService;
import com.team.house_backapi.utils.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {
    @Autowired(required = false)
    private UserService userService;

    @RequestMapping("/login")
    //用户的登录
    public BaseResult login(String name, String password, HttpSession session){
        Users admin = userService.login(name,password);
        if (admin!=null) {
            session.setAttribute("loginfo",admin);
            return new BaseResult(BaseResult.RESULT_SUCCESS, null, admin);
        }else {
            return new BaseResult(BaseResult.RESULT_FAIL,"登录错误");
        }
    }

    @RequestMapping("/regist")
    public BaseResult regist(Users users){
        int i = userService.regist(users);
        if(i>0){
            return new BaseResult(BaseResult.RESULT_SUCCESS,"");
        }else {
            return new BaseResult(BaseResult.RESULT_FAIL,"错误!");
        }

    }


}
