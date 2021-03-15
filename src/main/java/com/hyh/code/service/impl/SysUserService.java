package com.hyh.code.service.impl;

import com.hyh.code.mapper.SysUserMapper;
import com.hyh.code.pojo.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName SysUserService
 * @Description TODO
 * @Author Admin
 * @Date 2021/3/15 22:18
 * @Version 1.0
 **/
@Service
public class SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    public List<Map<String,Object>> findAll(SysUser sysUser) {
        List<Map<String,Object>> lists = sysUserMapper.findAll(sysUser);
        return lists;
    }

    public boolean insertSysUser(SysUser sysUser) {

        if (sysUserMapper.insertSelective(sysUser) > 0){
            return true;
        }else {
            return false;
        }
    }

    public boolean updateSysUser(SysUser sysUser) {

        if (sysUserMapper.updateByPrimaryKeySelective(sysUser) > 0){
            return true;
        }else {
            return false;
        }
    }

    public boolean deleteSysUser(SysUser sysUser) {
        sysUser.setIs_del(1);
        if (sysUserMapper.updateByPrimaryKeySelective(sysUser) > 0){
            return true;
        }else {
            return false;
        }
    }
}
