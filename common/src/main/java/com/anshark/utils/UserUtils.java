package com.anshark.utils;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author GUOYU
 * @Date 2021/5/27
 * @Desc
 */
@Slf4j
public class UserUtils {

    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void set(Integer userId) {
        threadLocal.set(userId);
    }

    public static Integer getUserId() {
        return threadLocal.get();
    }

    public static void remove() {
        threadLocal.remove();
    }
}
