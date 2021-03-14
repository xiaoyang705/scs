package com.hyh.code.service.impl;

import com.hyh.code.mapper.SysUserMapper;
import com.hyh.code.pojo.SysUser;
import com.hyh.code.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName LoginService
 * @Description TODO
 * @Author Admin
 * @Date 2021/3/11 0:24
 * @Version 1.0
 **/
@Service
public class LoginService {

    @Resource
    private SysUserMapper sysUserMapper;

    //使用RedisTemplate操作Redis
    @Autowired
    private RedisUtil redisUtil;

    public SysUser login(String login_name, String password) {
        SysUser memberUser = sysUserMapper.login(login_name, password);
        return memberUser;
    }


    public boolean logout(HttpServletRequest request) {
        String token = request.getHeader("token");
        Boolean delete = redisUtil.del(token);
        if (!delete) {
            return false;
        }
        return true;
    }
}
