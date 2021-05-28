package com.anshark.service;

import com.anshark.response.ResultType;

/**
 * @Author GUOYU
 * @Date 2021/5/26
 * @Desc
 */
public interface GyMenusService {

    /**
     * 获取所有menu
     * @param userId 用户ID
     * @return
     */
    ResultType getMenus(Integer userId);

    /**
     * 权限管理
     * @return
     */
    ResultType list();

}
