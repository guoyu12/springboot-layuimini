package com.anshark.dao.impl;

import com.anshark.dao.GyDataStatisticsDao;
import com.anshark.mapper.GyDataStatisticsMapper;
import com.anshark.model.GyDataStatistics;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @version 1.0
 * @Author GUOYU
 * @date 2021/6/13 13:44
 */
@Repository
public class GyDataStatisticsDaoImpl implements GyDataStatisticsDao {

    @Autowired
    private GyDataStatisticsMapper gyDataStatisticsMapper;

    @Override
    public GyDataStatistics findByDay(String format, String date) {
        QueryWrapper<GyDataStatistics> queryWrapper = new QueryWrapper<>();
        queryWrapper.apply("date_format(create_at,'" + format + "') = '" + date + "'");
        GyDataStatistics gyDataStatistics = gyDataStatisticsMapper.selectOne(queryWrapper);
        if (null == gyDataStatistics) {
            gyDataStatistics = new GyDataStatistics();
            gyDataStatistics.setTotalUserOnlineCountStatistics(0);
            gyDataStatistics.setTotalUserOnlineCount(0);
            gyDataStatistics.setTotalUserCount(0);
            gyDataStatistics.setTotalBrowseCount(0);
            gyDataStatistics.setTotalBrowseTodayCount(0);
        }
        return gyDataStatistics;
    }
}
