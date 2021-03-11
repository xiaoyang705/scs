package com.hyh.code.utils;

import java.util.UUID;

/**
 * @ClassName TokenUtils
 * @Description TODO
 * @Author Admin
 * @Date 2021/3/10 23:43
 * @Version 1.0
 **/
public class TokenUtils {
    private static final String MEMBER_TOKEN = "member_token";

    //token生成
    public static String getToken(){
        return MEMBER_TOKEN + UUID.randomUUID();
    }
}
