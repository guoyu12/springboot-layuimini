package com.anshark.dao.impl;

import com.anshark.dao.GyUserRoleDao;
import com.anshark.mapper.GyUserRoleMapper;
import com.anshark.model.GyUserRole;
import com.anshark.utils.CommonUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author GUOYU
 * @Date 2021/6/11
 * @Desc
 */
@Repository
public class GyUserRoleDaoImpl implements GyUserRoleDao {

    @Autowired
    private GyUserRoleMapper gyUserRoleMapper;

    @Override
    public void save(GyUserRole gyUserRole) {
        gyUserRoleMapper.insert(gyUserRole);
    }

    @Override
    public List<Integer> userRoleIds(Integer userId) {
        QueryWrapper<GyUserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        queryWrapper.eq("is_deleted", 0);
        GyUserRole gyUserRole = gyUserRoleMapper.selectOne(queryWrapper);
        if (null != gyUserRole) {
            String userRole = gyUserRole.getUserRole();
            if (StringUtils.isNotEmpty(userRole)) {
                List<String> list = Arrays.asList(userRole.split(","));
                return list.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
            }
        }
        return new ArrayList<>();
    }

    @Override
    public GyUserRole findByUserId(Integer userId) {
        QueryWrapper<GyUserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        queryWrapper.eq("is_deleted", 0);
        return gyUserRoleMapper.selectOne(queryWrapper);
    }

    @Override
    public void update(GyUserRole gyUserRole) {
        gyUserRoleMapper.updateById(gyUserRole);
    }
}
