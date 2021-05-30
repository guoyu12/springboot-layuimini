package com.anshark.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @Author GUOYU
 * @date 2021/5/30 16:30
 */
public class ClassUtils {

    /**
     * 获取实体类字段及值
     *
     * @return
     */
    public static Map<String, Object> getEntity(Object object) {

        Map<String, Object> map = new HashMap<>(10);

        try {
            // 得到类中的属性的所有的集合
            // 获取属性 此方法可以获得私有属性
            Field[] fields = object.getClass().getDeclaredFields();

            // 循环获取每个字段
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                // 设置属性可以访问
                field.setAccessible(true);
                // 得到此属性的值
                Object obj = field.get(object);
                // 字段名称
                String name = field.getName();
                map.put(name, obj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

}
