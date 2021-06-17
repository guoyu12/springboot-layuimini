package com.anshark.service.impl;

import com.anshark.dao.GyProjectInfoDao;
import com.anshark.model.GyProjectInfo;
import com.anshark.service.GyProjectInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author GUOYU
 * @Date 2021/6/17
 * @Desc
 */
@Service
public class GyProjectInfoServiceImpl implements GyProjectInfoService {

    @Autowired
    private GyProjectInfoDao gyProjectInfoDao;

    @Override
    public GyProjectInfo getGyProjectInfo() {
        return gyProjectInfoDao.findByOne();
    }
}
