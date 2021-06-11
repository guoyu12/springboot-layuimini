package com.anshark.dao.impl;

import com.anshark.dao.GyUserPermDao;
import com.anshark.mapper.GyUserPermMapper;
import com.anshark.model.GyUserPerm;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author GUOYU
 * @Date 2021/5/27
 * @Desc
 */
@Repository
public class GyUserPermDaoImpl implements GyUserPermDao {

    @Autowired
    private GyUserPermMapper gyUserPermMapper;

    @Override
    public GyUserPerm findByUserId(Integer userId) {
        QueryWrapper<GyUserPerm> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        queryWrapper.eq("is_deleted", 0);
        return gyUserPermMapper.selectOne(queryWrapper);
    }

    @Override
    public void update(GyUserPerm gyUserPerm) {
        gyUserPermMapper.updateById(gyUserPerm);
    }

    @Override
    public void save(GyUserPerm gyUserPerm) {
        gyUserPermMapper.insert(gyUserPerm);
    }
}
