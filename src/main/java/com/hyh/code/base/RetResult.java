package com.hyh.code.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("通用接口返回对象")
public class RetResult<T> {

    @ApiModelProperty(required = true,notes = "结果码",example = "200")
    public int code;
    @ApiModelProperty(required = true,notes = "返回信息",example = "SUCCESS")
    private String msg;
    @ApiModelProperty(required = false,notes = "返回数据",example = "{\"name\":\"blues\"}")
    private T data;

    public RetResult<T> setCode(RetCode retCode) {
        this.code = retCode.code;
        return this;
    }

    public int getCode() {
        return code;
    }

    public RetResult<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public RetResult<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public RetResult<T> setData(T data) {
        this.data = data;
        return this;
    }
}
