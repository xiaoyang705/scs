package com.hyh.code.pojo;

import javax.persistence.*;

@Table(name = "sys_role")
public class SysRole {
    /**
     * 角色id 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 角色名称 角色名称
     */
    private String role_name;

    /**
     * 角色首页 角色首页
     */
    private String role_home;

    /**
     * 所属单位 所属单位编号
     */
    private String org_id;

    /**
     * 角色描述 角色描述
     */
    private String role_desc;

    /**
     * 是否启用 使用情况0停用1启用
     */
    private Integer role_status;

    /**
     * 是否删除 1删除0存在
     */
    private Integer is_del;

    /**
     * 获取角色id 主键id
     *
     * @return id - 角色id 主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置角色id 主键id
     *
     * @param id 角色id 主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取角色名称 角色名称
     *
     * @return role_name - 角色名称 角色名称
     */
    public String getRole_name() {
        return role_name;
    }

    /**
     * 设置角色名称 角色名称
     *
     * @param role_name 角色名称 角色名称
     */
    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    /**
     * 获取角色首页 角色首页
     *
     * @return role_home - 角色首页 角色首页
     */
    public String getRole_home() {
        return role_home;
    }

    /**
     * 设置角色首页 角色首页
     *
     * @param role_home 角色首页 角色首页
     */
    public void setRole_home(String role_home) {
        this.role_home = role_home;
    }

    /**
     * 获取所属单位 所属单位编号
     *
     * @return org_id - 所属单位 所属单位编号
     */
    public String getOrg_id() {
        return org_id;
    }

    /**
     * 设置所属单位 所属单位编号
     *
     * @param org_id 所属单位 所属单位编号
     */
    public void setOrg_id(String org_id) {
        this.org_id = org_id;
    }

    /**
     * 获取角色描述 角色描述
     *
     * @return role_desc - 角色描述 角色描述
     */
    public String getRole_desc() {
        return role_desc;
    }

    /**
     * 设置角色描述 角色描述
     *
     * @param role_desc 角色描述 角色描述
     */
    public void setRole_desc(String role_desc) {
        this.role_desc = role_desc;
    }

    /**
     * 获取是否启用 使用情况0停用1启用
     *
     * @return role_status - 是否启用 使用情况0停用1启用
     */
    public Integer getRole_status() {
        return role_status;
    }

    /**
     * 设置是否启用 使用情况0停用1启用
     *
     * @param role_status 是否启用 使用情况0停用1启用
     */
    public void setRole_status(Integer role_status) {
        this.role_status = role_status;
    }

    /**
     * 获取是否删除 1删除0存在
     *
     * @return is_del - 是否删除 1删除0存在
     */
    public Integer getIs_del() {
        return is_del;
    }

    /**
     * 设置是否删除 1删除0存在
     *
     * @param is_del 是否删除 1删除0存在
     */
    public void setIs_del(Integer is_del) {
        this.is_del = is_del;
    }
}