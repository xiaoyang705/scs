package com.hyh.code.config;

import com.hyh.code.interceptor.AuthorizationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
    public AuthorizationInterceptor initAuthInterceptor() {
        return new AuthorizationInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //addPathPatterns : 拦截的路径 测试controller          excludePathPatterns： 不拦截的路径  登录controller
        registry.addInterceptor(initAuthInterceptor()).addPathPatterns("/scs/**").excludePathPatterns("/login/**");
    }
}
