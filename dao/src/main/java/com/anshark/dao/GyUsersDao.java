package com.anshark.dao;

import com.anshark.model.GyUsers;
import com.baomidou.mybatisplus.core.metadata.IPage;

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

    /**
     * 更新
     * @param gyUsers
     */
    void update(GyUsers gyUsers);

    /**
     * 分页
     * @param page
     * @param limit
     * @return
     */
    IPage<GyUsers> page(Integer page,Integer limit, String username, String phone, String email);

    /**
     * 添加
     * @param gyUsers
     */
    void save(GyUsers gyUsers);

}
