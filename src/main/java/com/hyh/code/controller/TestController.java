package com.hyh.code.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hyh.code.base.RetResponse;
import com.hyh.code.base.RetResult;
import com.hyh.code.pojo.Test;
import com.hyh.code.service.impl.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {

    @Resource
    private TestService testService;

    @GetMapping("/findAll1")
    public RetResult findAll(){

        List<Test> list = testService.findAllTest();
        return RetResponse.makeOKRsp(list);
    }


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
