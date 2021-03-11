package com.hyh.code.mapper;

import com.hyh.code.base.IBaseMapper;
import com.hyh.code.pojo.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysUserMapper extends IBaseMapper<SysUser> {

    SysUser login(@Param("userName") String userName, @Param("newPassWord") String newPassWord);
}