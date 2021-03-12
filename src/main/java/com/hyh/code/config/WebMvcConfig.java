package com.hyh.code.config;

import com.hyh.code.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName WebMvcConfig
 * @Description TODO
 * @Author Admin
 * @Date 2021/3/11 0:36
 * @Version 1.0
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public LoginInterceptor initLoginInterceptor() {
        return new LoginInterceptor();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //addPathPatterns : 拦截的路径 测试controller          excludePathPatterns： 不拦截的路径  登录controller
//        registry.addInterceptor(initLoginInterceptor())
//                .addPathPatterns("/api/**")
////                .excludePathPatterns("/doc.html").excludePathPatterns("/webjars/**")
//                .excludePathPatterns("/api/login");

        InterceptorRegistration ir = registry.addInterceptor(initLoginInterceptor());
        // 拦截路径
        ir.addPathPatterns("/*");
        // 不拦截路径
        List<String> irs = new ArrayList<String>();
        irs.add("/user/login");
        irs.add("/findAll1");
        // 开放knife4j
        irs.add("/doc.html");
        irs.add("/service-worker.js");
        irs.add("/swagger-resources");
        ir.excludePathPatterns(irs);

    }




}
