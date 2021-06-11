package com.anshark.dao.impl;

import com.anshark.dao.GyRolesDao;
import com.anshark.mapper.GyRolesMapper;
import com.anshark.model.GyRoles;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author GUOYU
 * @Date 2021/6/11
 * @Desc
 */
@Repository
public class GyRolesDaoImpl implements GyRolesDao {

    @Autowired
    private GyRolesMapper gyRolesMapper;

    @Override
    public List<GyRoles> roles() {
        QueryWrapper<GyRoles> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("is_deleted", 0);
        return gyRolesMapper.selectList(queryWrapper);
    }
}
