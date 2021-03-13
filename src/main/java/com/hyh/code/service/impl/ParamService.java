package com.hyh.code.service.impl;

import com.hyh.code.mapper.BaseParamsMapper;
import com.hyh.code.pojo.BaseParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @ClassName ParamService
 * @Description TODO
 * @Author Admin
 * @Date 2021/3/13 23:47
 * @Version 1.0
 **/
@Service
public class ParamService {

    @Autowired
    private BaseParamsMapper baseParamsMapper;


    public List<BaseParams> findAll(BaseParams baseParams) {

        Example example = new Example(BaseParams.class);
        Example.Criteria criteria = example.createCriteria();
        if (baseParams!=null && baseParams.getParam_code()!=null && !"".equals(baseParams.getParam_code()) ){
            criteria.andLike("param_code", baseParams.getParam_code().trim());
        }
        if (baseParams!=null && baseParams.getParam_name()!=null && !"".equals(baseParams.getParam_name()) ){
            criteria.andLike("param_name", baseParams.getParam_name().trim());
        }
        criteria.andEqualTo("is_del", 0);
        example.setOrderByClause("id desc");

        List<BaseParams> lists = baseParamsMapper.selectByExample(example);
        return lists;
    }


    public boolean insertParams(BaseParams baseParams) {
        if (baseParamsMapper.insertSelective(baseParams) > 0){
            return true;
        }else {
            return false;
        }
    }

    public boolean updateParams(BaseParams baseParams) {
        if (baseParamsMapper.updateByPrimaryKeySelective(baseParams) > 0){
            return true;
        }else {
            return false;
        }
    }

    public boolean deleteParams(BaseParams baseParams) {

        baseParams.setIs_del(1);
        if (baseParamsMapper.updateByPrimaryKeySelective(baseParams) > 0){
            return true;
        }else {
            return false;
        }
    }
}
