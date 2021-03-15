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
}
