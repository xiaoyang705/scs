package com.hyh.code.pojo;

import javax.persistence.*;

@Table(name = "base_params")
public class BaseParams {
    /**
     * 主键id 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 参数编号 参数编号
     */
    private String param_code;

    /**
     * 参数名称 参数名称
     */
    private String param_name;

    /**
     * 参数值 参数值
     */
    private String param_value;

    /**
     * 是否删除 1删除0存在
     */
    private Integer is_del;

    /**
     * 获取主键id 主键
     *
     * @return id - 主键id 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键id 主键
     *
     * @param id 主键id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取参数编号 参数编号
     *
     * @return param_code - 参数编号 参数编号
     */
    public String getParam_code() {
        return param_code;
    }

    /**
     * 设置参数编号 参数编号
     *
     * @param param_code 参数编号 参数编号
     */
    public void setParam_code(String param_code) {
        this.param_code = param_code;
    }

    /**
     * 获取参数名称 参数名称
     *
     * @return param_name - 参数名称 参数名称
     */
    public String getParam_name() {
        return param_name;
    }

    /**
     * 设置参数名称 参数名称
     *
     * @param param_name 参数名称 参数名称
     */
    public void setParam_name(String param_name) {
        this.param_name = param_name;
    }

    /**
     * 获取参数值 参数值
     *
     * @return param_value - 参数值 参数值
     */
    public String getParam_value() {
        return param_value;
    }

    /**
     * 设置参数值 参数值
     *
     * @param param_value 参数值 参数值
     */
    public void setParam_value(String param_value) {
        this.param_value = param_value;
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