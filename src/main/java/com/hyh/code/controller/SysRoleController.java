package com.hyh.code.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hyh.code.base.RetResponse;
import com.hyh.code.base.RetResult;
import com.hyh.code.pojo.SysRole;
import com.hyh.code.service.impl.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/role")
@Api(tags = "角色相关接口")
public class SysRoleController {


    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 根据条件分页查询所有的角色信息
     * @param sysRole
     * @param pageNo
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "分页获取角色列表")
    @PostMapping("/findByPage")
    public RetResult findByPage(@RequestBody(required = false) SysRole sysRole,
                                @RequestParam(defaultValue="1",required=true,value="pageNo") Integer pageNo,
                                @RequestParam(defaultValue="10",required=true,value="pageSize") Integer pageSize){


        PageHelper.startPage(pageNo, pageSize);
        List<Map<String,Object>> list = sysRoleService.findAll(sysRole);
        PageInfo<Map<String,Object>> pageInfo=new PageInfo<Map<String,Object>>(list);
        return RetResponse.makeOKRsp(pageInfo);
    }


    @ApiOperation(value = "角色详细页面查询")
    @PostMapping("/findByRecId/{id}")
    public RetResult findByRecId(@PathVariable("id") Integer id){

        Map<String,Object> map = sysRoleService.findByRecId(id);
        if (map!=null){

            return RetResponse.makeOKRsp(map);

        }else{
            return RetResponse.makeErrRsp("角色获取失败！");
        }
    }


    @ApiOperation(value = "新增角色", notes = "新增角色")
    @PostMapping("/insertSysRole")
    public RetResult insertSysRole(@RequestBody SysRole sysRole){

        if (StringUtils.isEmpty(sysRole.getOrg_id())) {
            return RetResponse.makeErrRsp("单位不能为空!");
        }
        if (StringUtils.isEmpty(sysRole.getRole_name())) {
            return RetResponse.makeErrRsp("角色名称不能为空!");
        }
        if(sysRoleService.insertSysRole(sysRole)){
            return RetResponse.makeOKRsp();
        }else{
            return RetResponse.makeErrRsp("新增失败！");
        }
    }


    @ApiOperation(value = "修改角色", notes = "修改角色")
    @PostMapping("/updateSysRole")
    public RetResult updateOrgInfo(@RequestBody SysRole sysRole){

        if (StringUtils.isEmpty(sysRole.getRole_name())) {
            return RetResponse.makeErrRsp("角色名称不能为空!");
        }
        if(sysRoleService.updateSysRole(sysRole)){
            return RetResponse.makeOKRsp();
        }else{
            return RetResponse.makeErrRsp("修改失败！");
        }
    }


    @ApiOperation(value = "设置角色授权")
    @PostMapping("/dealRoleFun")
    public RetResult dealRoleFun(@RequestBody Map<String,String> map){

        if (StringUtils.isEmpty(map.get("role_id"))) {
            return RetResponse.makeErrRsp("单位不能为空!");
        }

        if(sysRoleService.dealRoleFun(map)){
            return RetResponse.makeOKRsp();
        }else{
            return RetResponse.makeErrRsp("操作失败！");
        }
    }


}
