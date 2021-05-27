package com.anshark.config;

import com.anshark.interceptor.CheckLoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author GUOYU
 * @Date 2021/5/26
 * @Desc
 */
@Configuration
public class GyAdminConfig implements WebMvcConfigurer {

    @Autowired
    private CheckLoginInterceptor checkLoginInterceptor;

    public static final String[] excludeUrl = {"/static/**","/error","/favicon.ico","/users/page/setting.html","/users/page"};

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(checkLoginInterceptor).addPathPatterns("/**").excludePathPatterns(excludeUrl);

    }
}
