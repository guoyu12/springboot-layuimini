package com.anshark.dao;

import com.anshark.model.GyUsers;

/**
 * @Author GUOYU
 * @Date 2021/5/26
 * @Desc
 */
public interface GyUsersDao {

    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    GyUsers findByUsername(String username);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    GyUsers findById(Integer id);

}
