package com.anshark.dao;

import com.anshark.model.GyRoles;

import java.util.List;

/**
 * @Author GUOYU
 * @Date 2021/6/11
 * @Desc
 */
public interface GyRolesDao {

    /**
     * 所有角色
     */
    List<GyRoles> roles();

}
