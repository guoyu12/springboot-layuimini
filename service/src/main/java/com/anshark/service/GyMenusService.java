package com.anshark.service;

import com.anshark.model.GyMenus;
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
     * 权限管理MenuVO
     * @return
     */
    ResultType list();

    /**
     * 所有数据
     * @return
     */
    ResultType all();

    /**
     * 删除
     * @param id
     * @return
     */
    ResultType delete(Integer id);

    /**
     * 根据ID查询
     * @return
     */
    GyMenus findById(Integer id);

    ResultType update(GyMenus gyMenus);

}
