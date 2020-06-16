package com.team.house_backapi.controller;

import com.team.house_backapi.entity.Users;
import com.team.house_backapi.service.UserService;
import com.team.house_backapi.utils.BaseResult;
import com.team.house_backapi.utils.SendMsgUtil;
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

    @RequestMapping("/regist")//注册
    public BaseResult regist(Users users){
        int i = userService.regist(users);
        if(i>0){
            return new BaseResult(BaseResult.RESULT_SUCCESS,"");
        }else {
            return new BaseResult(BaseResult.RESULT_FAIL,"错误!");
        }

    }

    //登录 发送短信验证码 传入手机号发信息
    @RequestMapping("/sendCode")
    public BaseResult sendCode(String tel,HttpSession session){
        //1.生成随机验证码   生成四位
        int code=(int)Math.round((Math.random()+1) * 1000);
        //2.发送信息
        String msg="您的验证码是:"+code+",请尽快输入";
        //3.发送手机短信
        int result= SendMsgUtil.sendMsg(msg,tel);
        //使用session对象保存验证码  便于后期比较
        session.setAttribute("telCode",code);
        //session.setMaxInactiveInterval(60);
        return new BaseResult(result);
    }

    //实现验证登入验证  传code表示输入的验证码
    @RequestMapping("userLoginCode")
    public BaseResult userLoginCode(String code,HttpSession session){
        //获取输入验证码->比较验证码(手机验证码)
        //1.获取生成的手机验证码
        String telCode=session.getAttribute("telCode").toString();
        //2.比较
        if(telCode.equals(code)){
            //*获取手机号调用业务通过手机号查询用户的信息保存到session
            return new  BaseResult(BaseResult.RESULT_SUCCESS);
        }else{
            return new  BaseResult(BaseResult.RESULT_FAIL);
        }
    }

}
