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

    /**
     * 添加公告
     * @param gySystemNotice
     * @return
     */
    ResultType addSubmit(GySystemNotice gySystemNotice);

    /**
     * 删除
     * @param id
     * @return
     */
    ResultType del(Integer id);

    /**
     * 根据ID查找
     * @param id
     * @return
     */
    GySystemNotice findById(Integer id);

    /**
     * 提交更新
     * @param gySystemNotice
     * @return
     */
    ResultType update(GySystemNotice gySystemNotice);
}
