package com.anshark.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author GUOYU
 * @Date 2021/5/26
 * @Desc 静态资源加载
 */
@Configuration
public class StaticResourceConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //配置静态资源上传位置
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
