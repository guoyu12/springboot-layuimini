package com.anshark.dao.impl;

import com.anshark.dao.GyUsersDao;
import com.anshark.mapper.GyUsersMapper;
import com.anshark.model.GyUsers;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author GUOYU
 * @Date 2021/5/26
 * @Desc
 */
@Repository
public class GyUsersDaoImpl implements GyUsersDao {

    @Autowired
    private GyUsersMapper gyUsersMapper;

    @Override
    public GyUsers findByUsername(String username) {

        QueryWrapper<GyUsers> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        queryWrapper.eq("is_deleted", 0);

        return gyUsersMapper.selectOne(queryWrapper);
    }

    @Override
    public GyUsers findById(Integer id) {
        QueryWrapper<GyUsers> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        queryWrapper.eq("is_deleted", 0);
        return gyUsersMapper.selectOne(queryWrapper);
    }

    @Override
    public void update(GyUsers gyUsers) {
        gyUsersMapper.updateById(gyUsers);
    }

    @Override
    public IPage<GyUsers> page(Integer page, Integer limit) {
        QueryWrapper<GyUsers> queryWrapper = new QueryWrapper<>();
        Page<GyUsers> p = new Page<>(page, limit);
        IPage<GyUsers> iPage = gyUsersMapper.selectPage(p, queryWrapper);
        return iPage;
    }
}
