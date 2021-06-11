package com.anshark.dao.impl;

import com.anshark.dao.GyUserRoleDao;
import com.anshark.mapper.GyUserRoleMapper;
import com.anshark.model.GyUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
