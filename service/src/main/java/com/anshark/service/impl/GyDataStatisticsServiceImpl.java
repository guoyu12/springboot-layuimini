package com.anshark.service.impl;

import com.anshark.dao.GyDataStatisticsDao;
import com.anshark.model.GyDataStatistics;
import com.anshark.service.GyDataStatisticsService;
import com.anshark.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author GUOYU
 * @Date 2021/6/15
 * @Desc
 */
@Service
public class GyDataStatisticsServiceImpl implements GyDataStatisticsService {

    @Autowired
    private GyDataStatisticsDao gyDataStatisticsDao;

    @Override
    public Map<String, Object> statistics() {

        Map<String, Object> map = new HashMap<>(3);

        List<String> dateStrList = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            Date date = DateUtils.day(0 - i);
            dateStrList.add(DateUtils.getDateStr(date, DateUtils.DATE));
        }

        //倒序
        Collections.reverse(dateStrList);

        //日期
        map.put("dates", dateStrList);

        //类型
        List<String> types = new ArrayList<>();
        types.add("用户总数");
        types.add("用户在线次数");
        types.add("用户访问总数");
        types.add("用户日访问数");
        map.put("types", types);


        //七日用户总数
        List<Integer> totalUsers = new ArrayList<>();
        //七日在线数
        List<Integer> totalOnlineUsers = new ArrayList<>();
        //七日用户访问总数
        List<Integer> totalBrowseCount = new ArrayList<>();
        //用户日访问数
        List<Integer> totalBrowseCountByDay = new ArrayList<>();

        for (int i = 0; i < dateStrList.size(); i++) {

            GyDataStatistics gyDataStatistics = gyDataStatisticsDao.findByDay("%Y-%m-%d", dateStrList.get(i));

            if (null == gyDataStatistics) {
                totalUsers.add(0);
                totalOnlineUsers.add(0);
                totalBrowseCount.add(0);
                totalBrowseCountByDay.add(0);
            } else {
                totalUsers.add(gyDataStatistics.getTotalUserCount());
                totalOnlineUsers.add(gyDataStatistics.getTotalUserOnlineCountStatistics());
                totalBrowseCount.add(gyDataStatistics.getTotalBrowseCount());
                totalBrowseCountByDay.add(gyDataStatistics.getTotalBrowseTodayCount());
            }
        }

        Map<String, Object> series1 = new HashMap<>(1);
        series1.put("type", "line");
        series1.put("name", "用户总数");
        series1.put("data", totalUsers);

        Map<String, Object> series2 = new HashMap<>(1);
        series2.put("type", "line");
        series2.put("name", "用户在线次数");
        series2.put("data", totalOnlineUsers);

        Map<String, Object> series3 = new HashMap<>(1);
        series3.put("type", "line");
        series3.put("name", "用户访问总数");
        series3.put("data", totalBrowseCount);


        Map<String, Object> series4 = new HashMap<>(1);
        series4.put("type", "line");
        series4.put("name", "用户日访问数");
        series4.put("data", totalBrowseCountByDay);

        List<Map<String, Object>> series = new ArrayList<>();
        series.add(series1);
        series.add(series2);
        series.add(series3);
        series.add(series4);

        map.put("series", series);

        return map;
    }
}
