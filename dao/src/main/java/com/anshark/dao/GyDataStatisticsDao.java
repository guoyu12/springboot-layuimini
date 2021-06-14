package com.anshark.dao;

import com.anshark.model.GyDataStatistics;

/**
 * @version 1.0
 * @Author GUOYU
 * @date 2021/6/13 13:44
 */
public interface GyDataStatisticsDao {

    /**
     * 日期格式化
     * @param format
     * @param date
     * @return
     */
    GyDataStatistics findByDay(String format,String date);

}
