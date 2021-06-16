package com.anshark.dao;

import com.anshark.model.GyUserRole;

import java.util.List;

/**
 * @Author GUOYU
 * @Date 2021/6/11
 * @Desc
 */
public interface GyUserRoleDao {

    /**
     * 保存
     *
     * @param gyUserRole
     */
    void save(GyUserRole gyUserRole);

    /**
     * 用户拥有的权限ID
     *
     * @param userId
     * @return
     */
    List<Integer> userRoleIds(Integer userId);

    /**
     * 根据userId查找
     *
     * @param userId
     * @return
     */
    GyUserRole findByUserId(Integer userId);

    /**
     * 更新
     *
     * @param gyUserRole
     */
    void update(GyUserRole gyUserRole);
}
