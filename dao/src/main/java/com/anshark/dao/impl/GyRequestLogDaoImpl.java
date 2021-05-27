package com.anshark.dao.impl;

import com.anshark.dao.GyRequestLogDao;
import com.anshark.mapper.GyRequestLogMapper;
import com.anshark.model.GyRequestLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author GUOYU
 * @Date 2021/5/27
 * @Desc
 */
@Repository
public class GyRequestLogDaoImpl implements GyRequestLogDao {

    @Autowired
    private GyRequestLogMapper gyRequestLogMapper;

    @Override
    public void save(GyRequestLog gyRequestLog) {
        gyRequestLogMapper.insert(gyRequestLog);
    }
}
