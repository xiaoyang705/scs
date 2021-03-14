package com.hyh.code.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import javax.persistence.*;

@Table(name = "org_info")
public class OrgInfo {
    /**
     * 主键id 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 单位编号 单位编号
     */
    private String org_id;

    /**
     * 单位名称 单位名称
     */
    private String org_name;

    /**
     * 单位简称 单位简称
     */
    private String org_short_name;

    /**
     * 单位类型 1机关2企业
     */
    private Integer org_type;

    /**
     * 单位税务登记号 单位税务登记号
     */
    private String org_taxno;

    /**
     * 单位所属地区 单位所属地区
     */
    private String org_area;

    /**
     * 单位详细地址 单位详细地址
     */
    private String org_address;

    /**
     * 联系人 联系人
     */
    private String content_person;

    /**
     * 联系电话 联系电话
     */
    private String content_phone;

    /**
     * 服务期限 服务期限
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date service_time;

    /**
     * 使用状态 1在用0停用
     */
    private Integer org_status;

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
     * 获取单位编号 单位编号
     *
     * @return org_id - 单位编号 单位编号
     */
    public String getOrg_id() {
        return org_id;
    }

    /**
     * 设置单位编号 单位编号
     *
     * @param org_id 单位编号 单位编号
     */
    public void setOrg_id(String org_id) {
        this.org_id = org_id;
    }

    /**
     * 获取单位名称 单位名称
     *
     * @return org_name - 单位名称 单位名称
     */
    public String getOrg_name() {
        return org_name;
    }

    /**
     * 设置单位名称 单位名称
     *
     * @param org_name 单位名称 单位名称
     */
    public void setOrg_name(String org_name) {
        this.org_name = org_name;
    }

    /**
     * 获取单位简称 单位简称
     *
     * @return org_short_name - 单位简称 单位简称
     */
    public String getOrg_short_name() {
        return org_short_name;
    }

    /**
     * 设置单位简称 单位简称
     *
     * @param org_short_name 单位简称 单位简称
     */
    public void setOrg_short_name(String org_short_name) {
        this.org_short_name = org_short_name;
    }

    /**
     * 获取单位类型 1机关2企业
     *
     * @return org_type - 单位类型 1机关2企业
     */
    public Integer getOrg_type() {
        return org_type;
    }

    /**
     * 设置单位类型 1机关2企业
     *
     * @param org_type 单位类型 1机关2企业
     */
    public void setOrg_type(Integer org_type) {
        this.org_type = org_type;
    }

    /**
     * 获取单位税务登记号 单位税务登记号
     *
     * @return org_taxno - 单位税务登记号 单位税务登记号
     */
    public String getOrg_taxno() {
        return org_taxno;
    }

    /**
     * 设置单位税务登记号 单位税务登记号
     *
     * @param org_taxno 单位税务登记号 单位税务登记号
     */
    public void setOrg_taxno(String org_taxno) {
        this.org_taxno = org_taxno;
    }

    /**
     * 获取单位所属地区 单位所属地区
     *
     * @return org_area - 单位所属地区 单位所属地区
     */
    public String getOrg_area() {
        return org_area;
    }

    /**
     * 设置单位所属地区 单位所属地区
     *
     * @param org_area 单位所属地区 单位所属地区
     */
    public void setOrg_area(String org_area) {
        this.org_area = org_area;
    }

    /**
     * 获取单位详细地址 单位详细地址
     *
     * @return org_address - 单位详细地址 单位详细地址
     */
    public String getOrg_address() {
        return org_address;
    }

    /**
     * 设置单位详细地址 单位详细地址
     *
     * @param org_address 单位详细地址 单位详细地址
     */
    public void setOrg_address(String org_address) {
        this.org_address = org_address;
    }

    /**
     * 获取联系人 联系人
     *
     * @return content_person - 联系人 联系人
     */
    public String getContent_person() {
        return content_person;
    }

    /**
     * 设置联系人 联系人
     *
     * @param content_person 联系人 联系人
     */
    public void setContent_person(String content_person) {
        this.content_person = content_person;
    }

    /**
     * 获取联系电话 联系电话
     *
     * @return content_phone - 联系电话 联系电话
     */
    public String getContent_phone() {
        return content_phone;
    }

    /**
     * 设置联系电话 联系电话
     *
     * @param content_phone 联系电话 联系电话
     */
    public void setContent_phone(String content_phone) {
        this.content_phone = content_phone;
    }

    /**
     * 获取服务期限 服务期限
     *
     * @return service_time - 服务期限 服务期限
     */
    public Date getService_time() {
        return service_time;
    }

    /**
     * 设置服务期限 服务期限
     *
     * @param service_time 服务期限 服务期限
     */
    public void setService_time(Date service_time) {
        this.service_time = service_time;
    }

    /**
     * 获取使用状态 1在用0停用
     *
     * @return org_status - 使用状态 1在用0停用
     */
    public Integer getOrg_status() {
        return org_status;
    }

    /**
     * 设置使用状态 1在用0停用
     *
     * @param org_status 使用状态 1在用0停用
     */
    public void setOrg_status(Integer org_status) {
        this.org_status = org_status;
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