package com.anshark.jobhandler;

import com.alibaba.fastjson.JSONObject;
import com.anshark.dao.GyDataStatisticsDao;
import com.anshark.mapper.GyDataStatisticsMapper;
import com.anshark.mapper.GyRequestLogMapper;
import com.anshark.mapper.GyUsersMapper;
import com.anshark.model.GyDataStatistics;
import com.anshark.model.GyRequestLog;
import com.anshark.model.GyUsers;
import com.anshark.netty.websocket.handler.CustomerSocketHandler;
import com.anshark.netty.websocket.util.MsgType;
import com.anshark.response.ResultType;
import com.anshark.service.GyDataStatisticsService;
import com.anshark.service.GyMenusService;
import com.anshark.service.GySystemNoticeService;
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
    @Autowired
    private GyDataStatisticsService gyDataStatisticsService;
    @Autowired
    private GyMenusService gyMenusService;
    @Autowired
    private GySystemNoticeService gySystemNoticeService;
    @Autowired
    private GyDataStatisticsDao gyDataStatisticsDao;

    public GyDataStatistics gyDataStatistics() {
        QueryWrapper<GyDataStatistics> queryWrapper = new QueryWrapper<>();
        queryWrapper.apply("date_format(create_at,'%Y-%m-%d') = '" + DateUtils.getDateStr(new Date(), DateUtils.DATE) + "'");
        GyDataStatistics gyDataStatistics = gyDataStatisticsMapper.selectOne(queryWrapper);
        return gyDataStatistics;
    }

    /**
     * ???????????????
     */
    @XxlJob("totalUserCount")
    public void totalUserCount() {
        log.info("?????????????????????...");
        GyDataStatistics gyDataStatistics = gyDataStatistics();
        boolean isNull = false;
        if (null == gyDataStatistics) {
            isNull = true;
            gyDataStatistics = new GyDataStatistics();
        }
        Integer userCount = gyUsersMapper.selectCount(new QueryWrapper<GyUsers>().eq("is_deleted", 0));
        log.info("????????? -> {}", userCount);
        gyDataStatistics.setTotalUserCount(userCount);

        if (isNull) {
            gyDataStatisticsMapper.insert(gyDataStatistics);
        } else {
            gyDataStatisticsMapper.updateById(gyDataStatistics);
        }
    }

    /**
     * ?????????????????????
     */
    @XxlJob("totalUserOnlineCount")
    public void totalUserOnlineCount() {
        log.info("???????????????????????????...");
        GyDataStatistics gyDataStatistics = gyDataStatistics();
        boolean isNull = false;
        if (null == gyDataStatistics) {
            isNull = true;
            gyDataStatistics = new GyDataStatistics();
            gyDataStatistics.setTotalUserOnlineCount(0);
            gyDataStatistics.setTotalUserOnlineCountStatistics(0);
        }
        //??????????????????
        int totalUserOnlineCount = gyDataStatistics.getTotalUserOnlineCount();
        //????????????
        int count = 0;
        Map<String, Channel> map = CustomerSocketHandler.map;
        if (null != map) {
            count = map.size();
        }
        //???????????????????????????????????????????????????????????????
        if (count > totalUserOnlineCount) {
            gyDataStatistics.setTotalUserOnlineCountStatistics(gyDataStatistics.getTotalUserOnlineCountStatistics() + count - totalUserOnlineCount);
        }
        log.info("??????????????? -> {}", count);
        gyDataStatistics.setTotalUserOnlineCount(count);

        if (isNull) {
            gyDataStatisticsMapper.insert(gyDataStatistics);
        } else {
            gyDataStatisticsMapper.updateById(gyDataStatistics);
        }

    }

    /**
     * ?????????
     */
    @XxlJob("totalBrowseCount")
    public void totalBrowseCount() {
        log.info("?????????????????????...");
        GyDataStatistics gyDataStatistics = gyDataStatistics();
        boolean isNull = false;
        if (null == gyDataStatistics) {
            isNull = true;
            gyDataStatistics = new GyDataStatistics();
        }

        Integer count = gyRequestLogMapper.selectCount(new QueryWrapper<GyRequestLog>());
        log.info("????????? -> {}", count);
        gyDataStatistics.setTotalBrowseCount(count);

        if (isNull) {
            gyDataStatisticsMapper.insert(gyDataStatistics);
        } else {
            gyDataStatisticsMapper.updateById(gyDataStatistics);
        }
    }

    /**
     * ???????????????
     */
    @XxlJob("totalBrowseTodayCount")
    public void totalBrowseTodayCount() {
        log.info("???????????????????????????...");
        GyDataStatistics gyDataStatistics = gyDataStatistics();
        boolean isNull = false;
        if (null == gyDataStatistics) {
            isNull = true;
            gyDataStatistics = new GyDataStatistics();
        }

        QueryWrapper<GyRequestLog> queryWrapper = new QueryWrapper<>();
        queryWrapper.apply("date_format(create_at,'%Y-%m-%d') = '" + DateUtils.getDateStr(new Date(), DateUtils.DATE) + "'");
        Integer count = gyRequestLogMapper.selectCount(queryWrapper);
        log.info("??????????????? -> {}", count);
        gyDataStatistics.setTotalBrowseTodayCount(count);

        if (isNull) {
            gyDataStatisticsMapper.insert(gyDataStatistics);
        } else {
            gyDataStatisticsMapper.updateById(gyDataStatistics);
        }
    }

    /**
     * ????????????
     */
    @XxlJob("pushData")
    public void pushData() {
        log.info("??????push????????????...");
        GyDataStatistics gyDataStatistics = gyDataStatisticsService.findByDate(new Date());
        push(MsgType.CONNECTION_MSG, gyDataStatistics);

    }

    /**
     * ??????????????????
     */
    @XxlJob("pushReportForms")
    public void pushReportForms() {
        log.info("????????????????????????...");
        push(MsgType.REPORT_FORMS, gyDataStatisticsService.statistics());

    }

    /**
     * ??????????????????
     */
    @XxlJob("pushQuickEntry")
    public void pushQuickEntry() {
        log.info("????????????????????????...");
        push(MsgType.QUICK_ENTRY, gyMenusService.quickEntryList());
    }

    /**
     * ????????????
     */
    @XxlJob("pushNotice")
    void pushNotice() {
        log.info("????????????????????????");
        push(MsgType.SYS_NOTICES, gySystemNoticeService.list());
    }


    /**
     * ????????????
     *
     * @param msgType
     * @param data
     */
    void push(MsgType msgType, Object data) {
        Map<String, Channel> map = CustomerSocketHandler.map;
        Iterator<Map.Entry<String, Channel>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Channel> next = iterator.next();
            Channel channel = next.getValue();
            ResultType resultType = new ResultType();
            resultType.setCode(msgType.getCode());
            resultType.setMsg(msgType.getMsg());
            resultType.setData(data);
            channel.writeAndFlush(new TextWebSocketFrame(JSONObject.toJSONString(resultType)));
        }
    }
}
