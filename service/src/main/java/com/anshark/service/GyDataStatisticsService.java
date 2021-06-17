package com.anshark.service;

import com.anshark.model.GyDataStatistics;

import java.util.Date;
import java.util.Map;

/**
 * @Author GUOYU
 * @Date 2021/6/15
 * @Desc
 */
public interface GyDataStatisticsService {

    /**
     * 数据统计
     *
     * @return
     */
    Map<String, Object> statistics();

    /**
     * 日期
     * @param date
     * @return
     */
    GyDataStatistics findByDate(Date date);

}
