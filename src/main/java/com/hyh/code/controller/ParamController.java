package com.hyh.code.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hyh.code.base.RetResponse;
import com.hyh.code.base.RetResult;
import com.hyh.code.pojo.BaseParams;
import com.hyh.code.service.impl.ParamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @ClassName ParamController
 * @Description TODO
 * @Author Admin
 * @Date 2021/3/13 23:49
 * @Version 1.0
 **/
@RestController
@RequestMapping("/param")
@Api(tags = "系统参数相关接口")
public class ParamController {

    @Autowired
    private ParamService paramService;

    @ApiOperation(value = "分页获取系统参数列表", notes = "分页获取系统参数列表")
    @PostMapping("/findByPage")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "param_code",value = "参数编号",required = false,dataType = "String"),
            @ApiImplicitParam(name = "param_name",value = "参数名称",required = false,dataType = "String"),
            @ApiImplicitParam(name = "pageNo",value = "页码",required = true,dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize",value = "每页显示数",required = true,dataType = "Integer")
    })
    public RetResult findByPage(BaseParams baseParams, @RequestParam(defaultValue="1",required=true,value="pageNo") Integer pageNo,
                                @RequestParam(defaultValue="10",required=true,value="pageSize") Integer pageSize){

        //分页查询
        PageHelper.startPage(pageNo, pageSize);
        List<BaseParams> list = paramService.findAll(baseParams);
        PageInfo<BaseParams> pageInfo=new PageInfo<BaseParams>(list);
        return RetResponse.makeOKRsp(pageInfo);
    }


    @ApiOperation(value = "新增参数", notes = "新增参数")
    @PostMapping("/insertParams")
    public RetResult insertParams(@RequestBody BaseParams baseParams){

        if (StringUtils.isEmpty(baseParams.getParam_code())) {
            return RetResponse.makeErrRsp("参数编号不能为空!");
        }
        if (StringUtils.isEmpty(baseParams.getParam_name())) {
            return RetResponse.makeErrRsp("参数名不能为空!");
        }
        if (StringUtils.isEmpty(baseParams.getParam_value())) {
            return RetResponse.makeErrRsp("参数值不能为空!");
        }
        if(paramService.insertParams(baseParams)){
            return RetResponse.makeOKRsp();
        }else{
            return RetResponse.makeErrRsp("新增失败！");
        }
    }


    @ApiOperation(value = "修改参数", notes = "修改参数")
    @PostMapping("/updateParams")
    public RetResult updateParams(@RequestBody BaseParams baseParams){

        if (StringUtils.isEmpty(baseParams.getParam_name())) {
            return RetResponse.makeErrRsp("参数名不能为空!");
        }
        if (StringUtils.isEmpty(baseParams.getParam_value())) {
            return RetResponse.makeErrRsp("参数值不能为空!");
        }
        if(paramService.updateParams(baseParams)){
            return RetResponse.makeOKRsp();
        }else{
            return RetResponse.makeErrRsp("修改失败！");
        }
    }


    @ApiOperation(value = "删除参数", notes = "删除参数")
    @PostMapping("/deleteParams")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "id",required = true,dataType = "Integer")
    })
    public RetResult deleteParams(@RequestBody BaseParams baseParams){
        if (StringUtils.isEmpty(baseParams.getId())) {
            return RetResponse.makeErrRsp("删除id不能为空!");
        }

        if(paramService.deleteParams(baseParams)){
            return RetResponse.makeOKRsp();
        }else{
            return RetResponse.makeErrRsp("删除失败！");
        }
    }

}
