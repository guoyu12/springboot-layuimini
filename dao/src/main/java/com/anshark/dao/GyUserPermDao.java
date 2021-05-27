package com.anshark.dao;

import com.anshark.model.GyUserPerm;

/**
 * @Author GUOYU
 * @Date 2021/5/27
 * @Desc
 */
public interface GyUserPermDao {

    /**
     * 查询拥有的权限
     *
     * @param userId
     * @return
     */
    GyUserPerm findByUserId(Integer userId);

}
