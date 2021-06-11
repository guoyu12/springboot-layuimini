package com.anshark.service.impl;

import com.anshark.dao.GyRolesDao;
import com.anshark.response.ResultType;
import com.anshark.service.GyRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author GUOYU
 * @Date 2021/6/11
 * @Desc
 */
@Service
public class GyRolesServiceImpl implements GyRolesService {

    @Autowired
    private GyRolesDao gyRolesDao;

    @Override
    public ResultType roles() {
        return ResultType.success(gyRolesDao.roles());
    }
}
