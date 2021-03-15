package com.hyh.code.mapper;

import com.hyh.code.base.IBaseMapper;
import com.hyh.code.pojo.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
@Mapper
public interface SysRoleMapper extends IBaseMapper<SysRole> {


    List<Map<String,Object>> findAll(SysRole sysRole);

    Map<String,Object> findByRecId(@Param(value = "id") Integer id);

    void deleteRoleFun(@Param(value = "role_id")Integer role_id);

    void insertRoleFun(@Param(value = "role_id") Integer role_id, @Param(value = "fun_id")String fun_id);

    List<Integer> findSelectFun(@Param(value = "role_id")Integer id);

    List<Map<String,Object>> findFunParentId(@Param(value = "fun_parent") Integer fun_parent);
}