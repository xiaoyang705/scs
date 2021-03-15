package com.hyh.code.service.impl;

import com.hyh.code.mapper.SysRoleMapper;
import com.hyh.code.pojo.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Service
public class SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    public List<Map<String,Object>> findAll(SysRole sysRole) {

        List<Map<String,Object>> lists = sysRoleMapper.findAll(sysRole);
        return lists;
    }

    public Map<String,Object> findByRecId(Integer id) {
        return sysRoleMapper.findByRecId(id);
    }

    public boolean insertSysRole(SysRole sysRole) {

        if (sysRoleMapper.insertSelective(sysRole) > 0){
            return true;
        }else {
            return false;
        }
    }

    public boolean updateSysRole(SysRole sysRole) {
        if (sysRoleMapper.updateByPrimaryKeySelective(sysRole) > 0){
            return true;
        }else {
            return false;
        }
    }

    public boolean dealRoleFun(Map<String, String> map) {

        try {
            //删除原先数据
            Integer role_id = Integer.parseInt(map.get("role_id")+"");
            sysRoleMapper.deleteRoleFun(role_id);

            //判断是否存在设置的上级单位
            if (!StringUtils.isEmpty(map.get("fun_list"))){
                String array[] = map.get("fun_list").split(";");
                for (int i=0;i<array.length;i++){
                    sysRoleMapper.insertRoleFun(role_id,array[i]);
                }
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public List<Integer> findSelectFun(Integer id) {

        return sysRoleMapper.findSelectFun(id);
    }

    public List<Map<String,Object>> findAllFunTree() {

        //获取所有第一级
        List<Map<String,Object>> firstList = sysRoleMapper.findFunParentId(0);
        for (int i=0;i<firstList.size();i++){
            Map<String,Object> t1 = firstList.get(i);
            //获取下一级
            List<Map<String,Object>> secondList = sysRoleMapper.findFunParentId(Integer.parseInt(t1.get("fun_id")+""));
            for (int j=0;j<secondList.size();j++){
                Map<String,Object> t2 = secondList.get(j);
                //获取下一级
                List<Map<String,Object>> thirdList = sysRoleMapper.findFunParentId(Integer.parseInt(t2.get("fun_id")+""));
                t2.put("childList", thirdList);
            }
            t1.put("childList", secondList);
        }

        return firstList;
    }
}
