package com.anshark.service;

import com.anshark.model.GySystemNotice;
import com.anshark.response.ResultType;

import java.util.List;

/**
 * @Author GUOYU
 * @Date 2021/6/16
 * @Desc
 */
public interface GySystemNoticeService {

    /**
     * 数据
     * @return
     */
    List<GySystemNotice> list();

    /**
     * 分页数据
     * @param page
     * @param limit
     * @return
     */
    ResultType page(Integer page,Integer limit);
}
