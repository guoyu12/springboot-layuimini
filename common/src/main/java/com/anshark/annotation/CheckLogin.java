package com.anshark.annotation;

import java.lang.annotation.*;

/**
 * @Author GUOYU
 * @Date 2021/5/26
 * @Desc 检测登录
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface CheckLogin {

    boolean isCheck() default false;

}
