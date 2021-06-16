package com.anshark.service.impl;

import com.anshark.dao.GyRolesDao;
import com.anshark.dao.GyUserRoleDao;
import com.anshark.model.GyRoles;
import com.anshark.response.ResultType;
import com.anshark.service.GyRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author GUOYU
 * @Date 2021/6/11
 * @Desc
 */
@Service
public class GyRolesServiceImpl implements GyRolesService {

    @Autowired
    private GyRolesDao gyRolesDao;
    @Autowired
    private GyUserRoleDao gyUserRoleDao;


    @Override
    public ResultType roles() {
        return ResultType.success(gyRolesDao.roles());
    }

    @Override
    public List<GyRoles> dealEditData(Integer userId) {
        List<GyRoles> roles = gyRolesDao.roles();
        List<Integer> list = gyUserRoleDao.userRoleIds(userId);
        if (list.size() > 0) {
            roles.stream().forEach(s -> {
                if (list.contains(s.getId())) {
                    s.setIsCheck(1);
                } else {
                    s.setIsCheck(0);
                }
            });
        }
        return roles;
    }
}
