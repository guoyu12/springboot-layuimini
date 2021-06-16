package com.anshark.service;

import com.anshark.model.GyMenus;
import com.anshark.response.ResultType;

import java.util.List;

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

    /**
     * 添加菜单
     * @param gyMenus
     * @return
     */
    ResultType add(GyMenus gyMenus);

    /**
     * 用户菜单
     * @return
     */
    ResultType userTree(Integer userId);

    /**
     * 快捷入口菜单
     * @return
     */
    List<GyMenus> quickEntryList();

}
