package com.hyh.code.mapper;

import com.hyh.code.base.IBaseMapper;
import com.hyh.code.pojo.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Admin
 */
@Mapper
public interface SysUserMapper extends IBaseMapper<SysUser> {

    /**
     * @param login_name
     * @param password
     * @return
     */
    SysUser login(@Param("login_name") String login_name, @Param("password") String password);


}