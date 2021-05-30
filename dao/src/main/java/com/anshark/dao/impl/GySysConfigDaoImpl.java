package com.anshark.dao.impl;

import com.anshark.dao.GySysConfigDao;
import com.anshark.eum.Switch;
import com.anshark.mapper.GySysConfigMapper;
import com.anshark.model.GySysConfig;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @version 1.0
 * @Author GUOYU
 * @date 2021/5/30 15:48
 */
@Repository
public class GySysConfigDaoImpl implements GySysConfigDao {

    @Autowired
    private GySysConfigMapper gySysConfigMapper;

    @Override
    public List<GySysConfig> list() {

        QueryWrapper<GySysConfig> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("cfg_active", Switch.ON.name());
        return gySysConfigMapper.selectList(queryWrapper);
    }

    @Override
    public GySysConfig findByCfgName(String cfgName) {
        QueryWrapper<GySysConfig> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("cfg_name", cfgName);
        queryWrapper.eq("cfg_active", Switch.ON.name());
        return gySysConfigMapper.selectOne(queryWrapper);
    }

    @Override
    public void update(GySysConfig gySysConfig) {
        gySysConfigMapper.updateById(gySysConfig);
    }

}
