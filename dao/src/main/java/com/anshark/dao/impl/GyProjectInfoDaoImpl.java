package com.anshark.dao.impl;

import com.anshark.dao.GyProjectInfoDao;
import com.anshark.mapper.GyProjectInfoMapper;
import com.anshark.model.GyProjectInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author GUOYU
 * @Date 2021/6/17
 * @Desc
 */
@Repository
public class GyProjectInfoDaoImpl implements GyProjectInfoDao {

    @Autowired
    private GyProjectInfoMapper gyProjectInfoMapper;

    @Override
    public GyProjectInfo findByOne() {
        return gyProjectInfoMapper.selectById(1);
    }
}
