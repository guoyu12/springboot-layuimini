package com.anshark.dao;

import com.anshark.model.GySysConfig;

import java.util.List;

/**
 * @version 1.0
 * @Author GUOYU
 * @date 2021/5/30 15:48
 */
public interface GySysConfigDao {

    List<GySysConfig> list();

    GySysConfig findByCfgName(String cfgName);

    void save(GySysConfig gySysConfig);

}
