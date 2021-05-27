package com.anshark.dao;

import com.anshark.model.GyRequestLog;

/**
 * @Author GUOYU
 * @Date 2021/5/27
 * @Desc
 */
public interface GyRequestLogDao {

    /**
     * 添加数据
     *
     * @param gyRequestLog
     */
    void save(GyRequestLog gyRequestLog);

}
