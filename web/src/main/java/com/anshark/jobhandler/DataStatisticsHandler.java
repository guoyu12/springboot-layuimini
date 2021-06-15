package com.anshark.jobhandler;

import com.alibaba.fastjson.JSONObject;
import com.anshark.mapper.GyDataStatisticsMapper;
import com.anshark.mapper.GyRequestLogMapper;
import com.anshark.mapper.GyUsersMapper;
import com.anshark.model.GyDataStatistics;
import com.anshark.model.GyRequestLog;
import com.anshark.model.GyUsers;
import com.anshark.netty.websocket.handler.CustomerSocketHandler;
import com.anshark.response.ResultType;
import com.anshark.utils.DateUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxl.job.core.handler.annotation.XxlJob;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author GUOYU
 * @Date 2021/6/15
 * @Desc
 */
@Component
@Slf4j
public class DataStatisticsHandler {

    @Autowired
    private GyDataStatisticsMapper gyDataStatisticsMapper;
    @Autowired
    private GyUsersMapper gyUsersMapper;
    @Autowired
    private GyRequestLogMapper gyRequestLogMapper;

    public GyDataStatistics gyDataStatistics() {
        QueryWrapper<GyDataStatistics> queryWrapper = new QueryWrapper<>();
        queryWrapper.apply("date_format(create_at,'%Y-%m-%d') = '" + DateUtils.getDateStr(new Date(), DateUtils.DATE) + "'");
        GyDataStatistics gyDataStatistics = gyDataStatisticsMapper.selectOne(queryWrapper);
        return gyDataStatistics;
    }

    /**
     * 统计用户数
     */
    @XxlJob("totalUserCount")
    public void totalUserCount() {
        log.info("开启统计用户数...");
        GyDataStatistics gyDataStatistics = gyDataStatistics();
        boolean isNull = false;
        if (null == gyDataStatistics) {
            isNull = true;
            gyDataStatistics = new GyDataStatistics();
        }
        Integer userCount = gyUsersMapper.selectCount(new QueryWrapper<GyUsers>().eq("is_deleted", 0));
        log.info("用户数 -> {}", userCount);
        gyDataStatistics.setTotalUserCount(userCount);

        if (isNull) {
            gyDataStatisticsMapper.insert(gyDataStatistics);
        } else {
            gyDataStatisticsMapper.updateById(gyDataStatistics);
        }
    }

    /**
     * 统计在线用户数
     */
    @XxlJob("totalUserOnlineCount")
    public void totalUserOnlineCount() {
        log.info("开始统计在线用户数...");
        GyDataStatistics gyDataStatistics = gyDataStatistics();
        boolean isNull = false;
        if (null == gyDataStatistics) {
            isNull = true;
            gyDataStatistics = new GyDataStatistics();
            gyDataStatistics.setTotalUserOnlineCount(0);
            gyDataStatistics.setTotalUserOnlineCountStatistics(0);
        }
        //旧的在线人数
        int totalUserOnlineCount = gyDataStatistics.getTotalUserOnlineCount();
        //当前数据
        int count = 0;
        Map<String, Channel> map = CustomerSocketHandler.map;
        if (null != map) {
            count = map.size();
        }
        //如果在线人数大于旧的人数表示有新的数据登录
        if (count > totalUserOnlineCount) {
            gyDataStatistics.setTotalUserOnlineCountStatistics(gyDataStatistics.getTotalUserOnlineCountStatistics() + count - totalUserOnlineCount);
        }
        log.info("在线用户数 -> {}", count);
        gyDataStatistics.setTotalUserOnlineCount(count);

        if (isNull) {
            gyDataStatisticsMapper.insert(gyDataStatistics);
        } else {
            gyDataStatisticsMapper.updateById(gyDataStatistics);
        }

    }

    /**
     * 浏览数
     */
    @XxlJob("totalBrowseCount")
    public void totalBrowseCount() {
        log.info("开始统计浏览数...");
        GyDataStatistics gyDataStatistics = gyDataStatistics();
        boolean isNull = false;
        if (null == gyDataStatistics) {
            isNull = true;
            gyDataStatistics = new GyDataStatistics();
        }

        Integer count = gyRequestLogMapper.selectCount(new QueryWrapper<GyRequestLog>());
        log.info("浏览数 -> {}", count);
        gyDataStatistics.setTotalBrowseCount(count);

        if (isNull) {
            gyDataStatisticsMapper.insert(gyDataStatistics);
        } else {
            gyDataStatisticsMapper.updateById(gyDataStatistics);
        }
    }

    /**
     * 当日浏览数
     */
    @XxlJob("totalBrowseTodayCount")
    public void totalBrowseTodayCount() {
        log.info("开始统计当日浏览数...");
        GyDataStatistics gyDataStatistics = gyDataStatistics();
        boolean isNull = false;
        if (null == gyDataStatistics) {
            isNull = true;
            gyDataStatistics = new GyDataStatistics();
        }

        QueryWrapper<GyRequestLog> queryWrapper = new QueryWrapper<>();
        queryWrapper.apply("date_format(create_at,'%Y-%m-%d') = '" + DateUtils.getDateStr(new Date(), DateUtils.DATE) + "'");
        Integer count = gyRequestLogMapper.selectCount(queryWrapper);
        log.info("当日浏览数 -> {}", count);
        gyDataStatistics.setTotalBrowseTodayCount(count);

        if (isNull) {
            gyDataStatisticsMapper.insert(gyDataStatistics);
        } else {
            gyDataStatisticsMapper.updateById(gyDataStatistics);
        }
    }

    @XxlJob("push")
    public void push() {
        log.info("开始push实时数据...");
        QueryWrapper<GyDataStatistics> queryWrapper = new QueryWrapper<>();
        queryWrapper.apply("date_format(create_at,'%Y-%m-%d') = '" + DateUtils.getDateStr(new Date(), DateUtils.DATE) + "'");
        GyDataStatistics gyDataStatistics = gyDataStatisticsMapper.selectOne(queryWrapper);
        if (null == gyDataStatistics) {
            gyDataStatistics = new GyDataStatistics();
            gyDataStatistics.setTotalBrowseTodayCount(0);
            gyDataStatistics.setTotalBrowseCount(0);
            gyDataStatistics.setTotalUserCount(0);
            gyDataStatistics.setTotalUserOnlineCount(0);
        }
        Map<String, Channel> map = CustomerSocketHandler.map;
        Iterator<Map.Entry<String, Channel>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Channel> next = iterator.next();
            Channel channel = next.getValue();
            channel.writeAndFlush(new TextWebSocketFrame(JSONObject.toJSONString(ResultType.success(gyDataStatistics))));
        }

    }
}
