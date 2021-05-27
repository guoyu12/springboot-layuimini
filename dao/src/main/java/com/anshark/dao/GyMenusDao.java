package com.anshark.dao;

import com.anshark.model.GyMenus;

import java.util.List;

/**
 * @Author GUOYU
 * @Date 2021/5/26
 * @Desc
 */
public interface GyMenusDao {

    /**
     * 获取menu
     *
     * @param pid  父id
     * @param type 类型 0代表首页1 logo 2目录
     * @param ids
     * @return
     */
    List<GyMenus> getMenusBy(Integer pid, Integer type, List<Integer> ids);

}
