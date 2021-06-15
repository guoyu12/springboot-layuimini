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

    /**
     * 查询所有数据
     * @return
     */
    List<GyMenus> list();

    /**
     * 获取总数
     * @return
     */
    Integer count();

    /**
     * 更新
     * @param gyMenus
     */
    void update(GyMenus gyMenus);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    GyMenus findById(Integer id);

    /**
     * 查询所有子元素
     * @param parentId
     * @return
     */
    List<GyMenus> findByPid(Integer parentId);

    /**
     * 保存
     * @param gyMenus
     */
    void save(GyMenus gyMenus);

    /**
     * 快捷入口的数量
     * @return
     */
    Integer quickEntryCount();

    /**
     * 快捷入口菜单
     * @return
     */
    List<GyMenus> quickEntryList();
}
