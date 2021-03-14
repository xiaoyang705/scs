package com.hyh.code.pojo;

import javax.persistence.*;

/**
 * @author Admin
 */
@Table(name = "sys_user")
public class SysUser {
    /**
     * 主键id 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户名 用户名
     */
    private String user_name;

    /**
     * 登录账号 登录账号
     */
    private String login_name;

    /**
     * 登录密码 登录密码
     */
    private String password;

    /**
     * 手机号码 手机号码
     */
    private String user_phone;

    /**
     * 邮箱 邮箱
     */
    private String user_email;

    /**
     * 状态 状态
     */
    private Integer user_status;

    /**
     * 所属单位 所属单位
     */
    private String org_id;

    /**
     * 所属角色 所属角色id
     */
    private Integer role_id;

    /**
     * 是否删除 1删除0存在
     */
    private Integer is_del;

    /**
     * 获取主键id 主键id
     *
     * @return id - 主键id 主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键id 主键id
     *
     * @param id 主键id 主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户名 用户名
     *
     * @return user_name - 用户名 用户名
     */
    public String getUser_name() {
        return user_name;
    }

    /**
     * 设置用户名 用户名
     *
     * @param user_name 用户名 用户名
     */
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    /**
     * 获取登录账号 登录账号
     *
     * @return login_name - 登录账号 登录账号
     */
    public String getLogin_name() {
        return login_name;
    }

    /**
     * 设置登录账号 登录账号
     *
     * @param login_name 登录账号 登录账号
     */
    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    /**
     * 获取登录密码 登录密码
     *
     * @return password - 登录密码 登录密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置登录密码 登录密码
     *
     * @param password 登录密码 登录密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取手机号码 手机号码
     *
     * @return user_phone - 手机号码 手机号码
     */
    public String getUser_phone() {
        return user_phone;
    }

    /**
     * 设置手机号码 手机号码
     *
     * @param user_phone 手机号码 手机号码
     */
    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    /**
     * 获取邮箱 邮箱
     *
     * @return user_email - 邮箱 邮箱
     */
    public String getUser_email() {
        return user_email;
    }

    /**
     * 设置邮箱 邮箱
     *
     * @param user_email 邮箱 邮箱
     */
    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    /**
     * 获取状态 状态
     *
     * @return user_status - 状态 状态
     */
    public Integer getUser_status() {
        return user_status;
    }

    /**
     * 设置状态 状态
     *
     * @param user_status 状态 状态
     */
    public void setUser_status(Integer user_status) {
        this.user_status = user_status;
    }

    /**
     * 获取所属单位 所属单位
     *
     * @return org_id - 所属单位 所属单位
     */
    public String getOrg_id() {
        return org_id;
    }

    /**
     * 设置所属单位 所属单位
     *
     * @param org_id 所属单位 所属单位
     */
    public void setOrg_id(String org_id) {
        this.org_id = org_id;
    }

    /**
     * 获取所属角色 所属角色id
     *
     * @return role_id - 所属角色 所属角色id
     */
    public Integer getRole_id() {
        return role_id;
    }

    /**
     * 设置所属角色 所属角色id
     *
     * @param role_id 所属角色 所属角色id
     */
    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
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