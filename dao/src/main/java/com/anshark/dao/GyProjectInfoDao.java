package com.anshark.dao;

import com.anshark.model.GyProjectInfo;

/**
 * @Author GUOYU
 * @Date 2021/6/17
 * @Desc
 */
public interface GyProjectInfoDao {

    /**
     * 查询数据
     * @return
     */
    GyProjectInfo findByOne();

}
