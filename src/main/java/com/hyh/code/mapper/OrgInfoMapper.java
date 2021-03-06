package com.hyh.code.mapper;

import com.hyh.code.base.IBaseMapper;
import com.hyh.code.pojo.OrgInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Admin
 */
@Mapper
public interface OrgInfoMapper extends IBaseMapper<OrgInfo> {

    List<Map<String,Object>> findUpOrg(@Param("org_id") String org_id);

    List<Map<String,Object>> findLowOrg(@Param("org_id") String org_id);

    String findAreaName(@Param("area_id") String area_id);

    void deleteUpOrg(@Param("org_id") String org_id);

    void insertUpOrg(@Param("org_id") String org_id,@Param("up_org") String up_org);

    void deleteLowOrg(@Param("org_id") String org_id);

    void insertLowOrg(@Param("org_id") String org_id,@Param("low_org") String low_org);
}