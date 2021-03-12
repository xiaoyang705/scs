package com.hyh.code.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hyh.code.base.RetResponse;
import com.hyh.code.base.RetResult;
import com.hyh.code.pojo.Test;
import com.hyh.code.service.impl.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(value = "IndexController测试接口")
public class TestController {

    @Resource
    private TestService testService;

    @ApiOperation(value = "测试index22接口", nickname = "测试IndexController的index接口")
    @GetMapping("/findAll1")
    public RetResult findAll(){

        List<Test> list = testService.findAllTest();
        return RetResponse.makeOKRsp(list);
    }

    @ApiOperation(value = "用户登录测试接口222", notes = "用户登录试接口000")
    @GetMapping("/findByPage")
    public RetResult findByPage(Test test,@RequestParam(defaultValue="1",required=true,value="pageNo") Integer pageNo,
                                @RequestParam(defaultValue="1",required=true,value="pageSize") Integer pageSize){

        //分页查询
        PageHelper.startPage(pageNo, pageSize);
        List<Test> list = testService.findAllTest();
        PageInfo<Test> pageInfo=new PageInfo<Test>(list);
        return RetResponse.makeOKRsp(pageInfo);
    }
}
