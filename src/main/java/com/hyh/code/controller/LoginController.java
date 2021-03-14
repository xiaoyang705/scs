package com.hyh.code.controller;

import com.hyh.code.base.RetResponse;
import com.hyh.code.base.RetResult;
import com.hyh.code.pojo.SysUser;
import com.hyh.code.service.impl.LoginService;
import com.hyh.code.utils.MD5Util;
import com.hyh.code.utils.RedisUtil;
import com.hyh.code.utils.TokenUtils;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author Admin
 * @Date 2021/3/11 0:26
 * @Version 1.0
 **/
@Api(tags = "登录相关接口")
@RestController
public class LoginController {

    static Logger log = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private LoginService loginService;

    @Autowired
    private RedisUtil redisUtil;

    @PostMapping("/user/login")
    @ApiOperation(value = "登陆接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "login_name",value = "用户名称",required = true,dataType = "String"),
            @ApiImplicitParam(name = "password",value = "密码",required = true,dataType = "String")
    })
    public RetResult login(String login_name,String password){

        // 1.验证参数
        if (StringUtils.isEmpty(login_name)) {
            return RetResponse.makeErrRsp("用户名称不能为空!");
        }
        if (StringUtils.isEmpty(password)) {
            return RetResponse.makeErrRsp("密码不能为空!");
        }

        //生成token
        String token = TokenUtils.getToken();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("token", token);
        if ("super".equals(login_name) && "super123456".equals(password)){
            //判断该账号为平台管理员
            map.put("userType", 1);
        }else{
            map.put("userType", 2);
        }

        SysUser user = loginService.login(login_name, MD5Util.md5(password));
        if (user == null) {
            return RetResponse.makeErrRsp("账号或密码错误!");
        }
        //userId
        Integer userId = user.getId();
        //存放Redis
        redisUtil.set(token, String.valueOf(userId));
        log.info("【用户信息token存放在Redis中.....key为】：{},value为：{}", token, String.valueOf(userId));
        map.put("user", user);
        return RetResponse.makeOKRsp(map);
    }



    @PostMapping(value = "/user/logout")
    @ApiOperation(value = "注销测试接口", notes = "访问此接口，返回hello语句，测试接口")
    public RetResult logout(HttpServletRequest request) {
        boolean flag = loginService.logout(request);
        if (flag) {
            return RetResponse.makeOKRsp("注销成功");
        }
        return RetResponse.makeErrRsp("注销失败");
    }

}
