package com.hyh.code.base;

public enum RetCode {
    // 成功
    SUCCESS(200),

    // 失败
    FAIL(400),

    // 未认证（签名错误）
    UNAUTHORIZED(401),

    // 过期（签名错误）
    RESCODE_LOGINEXPIRE (1004),

    // 重复登录（签名错误）
    CODE_LOGINOTHERADDR_ERROR (1014),

    // 接口不存在
    NOT_FOUND(404),

    // 服务器内部错误
    INTERNAL_SERVER_ERROR(500);

    public int code;

    RetCode(int code) {
        this.code = code;
    }
}
