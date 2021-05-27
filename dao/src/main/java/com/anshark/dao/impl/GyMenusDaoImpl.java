package com.anshark.dao.impl;

import com.anshark.dao.GyMenusDao;
import com.anshark.mapper.GyMenusMapper;
import com.anshark.model.GyMenus;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author GUOYU
 * @Date 2021/5/26
 * @Desc
 */
@Repository
public class GyMenusDaoImpl implements GyMenusDao {

    @Autowired
    private GyMenusMapper gyMenusMapper;

    @Override
    public List<GyMenus> getMenusBy(Integer pid, Integer type, List<Integer> ids) {

        QueryWrapper<GyMenus> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id", pid);
        queryWrapper.eq("type", type);
        queryWrapper.orderByAsc("sort");
        if(null != ids && ids.size() > 0){
            queryWrapper.in("id", ids);
        }
        return gyMenusMapper.selectList(queryWrapper);
    }

}