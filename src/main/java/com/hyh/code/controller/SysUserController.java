package com.hyh.code.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hyh.code.base.RetResponse;
import com.hyh.code.base.RetResult;
import com.hyh.code.pojo.OrgInfo;
import com.hyh.code.pojo.SysRole;
import com.hyh.code.pojo.SysUser;
import com.hyh.code.service.impl.SysUserService;
import com.hyh.code.utils.MD5Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName SysUserController
 * @Description TODO
 * @Author Admin
 * @Date 2021/3/15 22:12
 * @Version 1.0
 **/
@RestController
@RequestMapping("/user")
@Api(tags = "用户相关接口")
public class SysUserController {


    @Autowired
    private SysUserService sysUserService;

    /**
     * 根据条件分页查询所有的用户信息
     * @param sysUser
     * @param pageNo
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "分页获取角色列表")
    @PostMapping("/findByPage")
    public RetResult findByPage(@RequestBody(required = false) SysUser sysUser,
                                @RequestParam(defaultValue="1",required=true,value="pageNo") Integer pageNo,
                                @RequestParam(defaultValue="10",required=true,value="pageSize") Integer pageSize){


        PageHelper.startPage(pageNo, pageSize);
        List<Map<String,Object>> list = sysUserService.findAll(sysUser);
        PageInfo<Map<String,Object>> pageInfo=new PageInfo<Map<String,Object>>(list);
        return RetResponse.makeOKRsp(pageInfo);
    }


    @ApiOperation(value = "新增用户", notes = "新增用户")
    @PostMapping("/insertSysUser")
    public RetResult insertSysUser(@RequestBody SysUser sysUser){

        if (StringUtils.isEmpty(sysUser.getUser_name())) {
            return RetResponse.makeErrRsp("用户名不能为空!");
        }
        if (StringUtils.isEmpty(sysUser.getLogin_name())) {
            return RetResponse.makeErrRsp("登录账号不能为空!");
        }
        if (StringUtils.isEmpty(sysUser.getPassword())) {
            return RetResponse.makeErrRsp("登录密码不能为空!");
        }
        if (StringUtils.isEmpty(sysUser.getOrg_id())) {
            return RetResponse.makeErrRsp("所属单位不能为空!");
        }
        if (StringUtils.isEmpty(sysUser.getRole_id())) {
            return RetResponse.makeErrRsp("所属单位不能为空!");
        }

        sysUser.setPassword(MD5Util.md5(sysUser.getPassword()));
        if(sysUserService.insertSysUser(sysUser)){
            return RetResponse.makeOKRsp();
        }else{
            return RetResponse.makeErrRsp("新增失败！");
        }
    }

    @ApiOperation(value = "修改用户", notes = "修改用户")
    @PostMapping("/updateSysUser")
    public RetResult updateSysUser(@RequestBody SysUser sysUser){


        if(sysUserService.updateSysUser(sysUser)){
            return RetResponse.makeOKRsp();
        }else{
            return RetResponse.makeErrRsp("修改失败！");
        }
    }



    @ApiOperation(value = "删除用户", notes = "删除用户")
    @PostMapping("/deleteSysUser")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "id",required = true,dataType = "Integer")
    })
    public RetResult deleteSysUser(@RequestBody SysUser sysUser){
        if (StringUtils.isEmpty(sysUser.getId())) {
            return RetResponse.makeErrRsp("删除id不能为空!");
        }

        if(sysUserService.deleteSysUser(sysUser)){
            return RetResponse.makeOKRsp();
        }else{
            return RetResponse.makeErrRsp("删除失败！");
        }
    }
}
