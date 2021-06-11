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

    /**
     * 更新
     * @param gyUserPerm
     * @return
     */
    void update(GyUserPerm gyUserPerm);

    /**
     * 添加保存
     * @param gyUserPerm
     */
    void save(GyUserPerm gyUserPerm);

}
