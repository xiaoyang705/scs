package com.hyh.code.service.impl;

import com.hyh.code.mapper.OrgInfoMapper;
import com.hyh.code.pojo.OrgInfo;
import com.hyh.code.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

/**
 * @ClassName OrgInfoService
 * @Description TODO
 * @Author Admin
 * @Date 2021/3/14 21:29
 * @Version 1.0
 **/
@Service
public class OrgInfoService {

    @Autowired
    private OrgInfoMapper orgInfoMapper;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 根据条件查询所有的单位
     * @param orgInfo
     * @return
     */
    public List<OrgInfo> findAll(OrgInfo orgInfo) {

        Example example = new Example(OrgInfo.class);
        Example.Criteria criteria = example.createCriteria();
        if (orgInfo!=null && orgInfo.getOrg_id()!=null && !"".equals(orgInfo.getOrg_id())){
            criteria.andEqualTo("org_id", orgInfo.getOrg_id());
        }
        if (orgInfo!=null && orgInfo.getOrg_name()!=null && !"".equals(orgInfo.getOrg_name())){
            criteria.andLike("org_name", orgInfo.getOrg_name());
        }
        criteria.andEqualTo("is_del", 0);
        example.setOrderByClause("id desc");

        List<OrgInfo> lists = orgInfoMapper.selectByExample(example);
        return lists;
    }


    /**
     * 根据id查询单位
     * @param id
     * @return
     */
    public OrgInfo findByRecId(Integer id) {

        return orgInfoMapper.selectByPrimaryKey(id);
    }



    public List<Map<String,Object>> findUpOrg(String org_id) {

        return orgInfoMapper.findUpOrg(org_id);
    }

    public List<Map<String,Object>> findLowOrg(String org_id) {
        return orgInfoMapper.findLowOrg(org_id);
    }

    public String findAreaName(String org_area) {

        String t1 = orgInfoMapper.findAreaName(org_area.substring(0, 2)+"0000");
        String t2 = orgInfoMapper.findAreaName(org_area.substring(0, 4)+"00");
        String t3 = orgInfoMapper.findAreaName(org_area);

        return t1+t2+t3;
    }

    public boolean insertOrgInfo(OrgInfo orgInfo) {

        //根据当前系统情况自动产生org_id
        String orgId = getSystemOrgId();
        orgInfo.setOrg_id(orgId);

        if (orgInfoMapper.insertSelective(orgInfo) > 0){
            return true;
        }else {
            return false;
        }
    }

    public boolean updateOrgInfo(OrgInfo orgInfo) {


        if (orgInfoMapper.updateByPrimaryKeySelective(orgInfo) > 0){
            return true;
        }else {
            return false;
        }
    }



    public boolean deleteOrgInfo(OrgInfo orgInfo) {

        orgInfo.setIs_del(1);
        if (orgInfoMapper.updateByPrimaryKeySelective(orgInfo) > 0){
            return true;
        }else {
            return false;
        }
    }

    private String getSystemOrgId() {
        long no = 100000000+redisUtil.incr("orgCount", 1);
        return String.valueOf(no);
    }



    public boolean dealUpOrg(Map<String, String> map) {
        try {
            //删除原先数据
            String org_id = map.get("org_id")+"";
            orgInfoMapper.deleteUpOrg(org_id);

            //判断是否存在设置的上级单位
            if (!StringUtils.isEmpty(map.get("org_list"))){
                String array[] = map.get("org_list").split(";");
                for (int i=0;i<array.length;i++){
                    orgInfoMapper.insertUpOrg(org_id,array[i]);
                }
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }




    public boolean dealLowOrg(Map<String, String> map) {
        try {
            //删除原先数据
            String org_id = map.get("org_id")+"";
            orgInfoMapper.deleteLowOrg(org_id);

            //判断是否存在设置的上级单位
            if (!StringUtils.isEmpty(map.get("org_list"))){
                String array[] = map.get("org_list").split(";");
                for (int i=0;i<array.length;i++){
                    orgInfoMapper.insertLowOrg(org_id,array[i]);
                }
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
