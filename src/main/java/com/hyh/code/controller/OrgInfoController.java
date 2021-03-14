package com.hyh.code.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hyh.code.base.RetResponse;
import com.hyh.code.base.RetResult;
import com.hyh.code.pojo.BaseParams;
import com.hyh.code.pojo.OrgInfo;
import com.hyh.code.service.impl.OrgInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName OrgInfoController
 * @Description TODO
 * @Author Admin
 * @Date 2021/3/14 21:28
 * @Version 1.0
 **/
@RestController
@RequestMapping("/orgInfo")
@Api(tags = "单位相关接口")
public class OrgInfoController {

    @Autowired
    private OrgInfoService orgInfoService;


    /**
     * 根据条件分页查询所有的单位信息
     * @param orgInfo
     * @param pageNo
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "分页获取单位列表")
    @PostMapping("/findByPage")
    public RetResult findByPage(OrgInfo orgInfo,
                                @RequestParam(defaultValue="1",required=true,value="pageNo") Integer pageNo,
                                @RequestParam(defaultValue="10",required=true,value="pageSize") Integer pageSize){


        PageHelper.startPage(pageNo, pageSize);
        List<OrgInfo> list = orgInfoService.findAll(orgInfo);
        PageInfo<OrgInfo> pageInfo=new PageInfo<OrgInfo>(list);
        return RetResponse.makeOKRsp(pageInfo);
    }


    @ApiOperation(value = "单位详细页面查询")
    @PostMapping("/findByRecId/{id}")
    public RetResult findByRecId(@PathVariable("id") Integer id){

        OrgInfo orgInfo = orgInfoService.findByRecId(id);
        if (orgInfo!=null){
            //获取当前的单位的上级单位
            List<Map<String,Object>> upOrgList = orgInfoService.findUpOrg(orgInfo.getOrg_id());
            //获取当前的单位的下级单位
            List<Map<String,Object>> lowOrgList = orgInfoService.findLowOrg(orgInfo.getOrg_id());
            //获取当前单位的所属地区
            String areaName = orgInfoService.findAreaName(orgInfo.getOrg_area());

            Map<String,Object> data = new HashMap<String,Object>();
            data.put("orgInfo", orgInfo);
            data.put("upOrgList", upOrgList);
            data.put("lowOrgList", lowOrgList);
            data.put("areaName", areaName);

            return RetResponse.makeOKRsp(data);

        }else{
            return RetResponse.makeErrRsp("单位获取失败！");
        }
    }


    @ApiOperation(value = "新增单位", notes = "新增单位")
    @PostMapping("/insertOrgInfo")
    public RetResult insertOrgInfo(@RequestBody OrgInfo OrgInfo){

        if (StringUtils.isEmpty(OrgInfo.getOrg_name())) {
            return RetResponse.makeErrRsp("单位名称不能为空!");
        }
        if (StringUtils.isEmpty(OrgInfo.getOrg_short_name())) {
            return RetResponse.makeErrRsp("单位简称不能为空!");
        }
        if(orgInfoService.insertOrgInfo(OrgInfo)){
            return RetResponse.makeOKRsp();
        }else{
            return RetResponse.makeErrRsp("新增失败！");
        }
    }

    @ApiOperation(value = "修改单位", notes = "修改单位")
    @PostMapping("/updateOrgInfo")
    public RetResult updateOrgInfo(@RequestBody OrgInfo OrgInfo){

        if (StringUtils.isEmpty(OrgInfo.getOrg_name())) {
            return RetResponse.makeErrRsp("单位名称不能为空!");
        }
        if (StringUtils.isEmpty(OrgInfo.getOrg_short_name())) {
            return RetResponse.makeErrRsp("单位简称不能为空!");
        }
        if(orgInfoService.updateOrgInfo(OrgInfo)){
            return RetResponse.makeOKRsp();
        }else{
            return RetResponse.makeErrRsp("修改失败！");
        }
    }



    @ApiOperation(value = "删除单位", notes = "删除单位")
    @PostMapping("/deleteOrgInfo")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "id",required = true,dataType = "Integer")
    })
    public RetResult deleteOrgInfo(@RequestBody OrgInfo orgInfo){
        if (StringUtils.isEmpty(orgInfo.getId())) {
            return RetResponse.makeErrRsp("删除id不能为空!");
        }

        if(orgInfoService.deleteOrgInfo(orgInfo)){
            return RetResponse.makeOKRsp();
        }else{
            return RetResponse.makeErrRsp("删除失败！");
        }
    }


    @ApiOperation(value = "上级单位页面数据获取")
    @PostMapping("/showUpOrgList")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "选择单位",value = "org_id",required = true,dataType = "String")
    })
    public RetResult showUpOrgList(String org_id){

        if (StringUtils.isEmpty(org_id)) {
            return RetResponse.makeErrRsp("参数不能为空!");
        }

        //获取系统所有单位信息
        List<OrgInfo> allOrgList = orgInfoService.findAll(null);
        //获取已选择的上级单位
        List<Map<String,Object>> upOrgList = orgInfoService.findUpOrg(org_id);

        Map<String,Object> data = new HashMap<String,Object>();
        data.put("allOrgList", allOrgList);
        data.put("upOrgList", upOrgList);

        return RetResponse.makeOKRsp(data);
    }


    @ApiOperation(value = "下级单位页面数据获取")
    @PostMapping("/showLowOrgList")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "选择单位",value = "org_id",required = true,dataType = "String")
    })
    public RetResult showLowOrgList(String org_id){

        if (StringUtils.isEmpty(org_id)) {
            return RetResponse.makeErrRsp("参数不能为空!");
        }

        //获取系统所有单位信息
        List<OrgInfo> allOrgList = orgInfoService.findAll(null);
        //获取已选择的上级单位
        List<Map<String,Object>> lowOrgList = orgInfoService.findLowOrg(org_id);

        Map<String,Object> data = new HashMap<String,Object>();
        data.put("allOrgList", allOrgList);
        data.put("lowOrgList", lowOrgList);

        return RetResponse.makeOKRsp(data);
    }

}
