package com.hyh.code.controller;

import com.hyh.code.base.RetResponse;
import com.hyh.code.base.RetResult;
import com.hyh.code.pojo.SysUser;
import com.hyh.code.service.impl.LoginService;
import com.hyh.code.utils.MD5Util;
import com.hyh.code.utils.RedisUtil;
import com.hyh.code.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author Admin
 * @Date 2021/3/11 0:26
 * @Version 1.0
 **/
@RestController
@Slf4j
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private RedisUtil redisUtil;


    @PostMapping("/user/login")
    public RetResult login(@RequestBody SysUser sysUser){

        // 1.验证参数
        String userName = sysUser.getUsername();
        if (StringUtils.isEmpty(userName)) {
            return RetResponse.makeErrRsp("用户名称不能为空!");
        }
        String password = sysUser.getPassword();
        if (StringUtils.isEmpty(password)) {
            return RetResponse.makeErrRsp("密码不能为空!");
        }
        //String newPassWord = MD5Util.encode(password);

        SysUser user = loginService.login(userName, password);
        if (user == null) {
            return RetResponse.makeErrRsp("账号或密码错误!");
        }
        //生成token
        String token = TokenUtils.getToken();
        //userId
        Integer userId = user.getId();
        //存放Redis
        redisUtil.set(token, "login_"+String.valueOf(userId));
        log.info("【用户信息token存放在Redis中.....key为】：{},value为：{}", token, "login_"+String.valueOf(userId));

        return RetResponse.makeOKRsp(token);
    }


    @RequestMapping(value = "/user/logout")
    public RetResult logout(HttpServletRequest request) {
        boolean flag = loginService.logout(request);
        if (flag) {
            return RetResponse.makeOKRsp("注销成功");
        }
        return RetResponse.makeErrRsp("注销失败");
    }

}
