package com.anshark.dao;

import com.anshark.model.GySystemNotice;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * @Author GUOYU
 * @Date 2021/6/16
 * @Desc
 */
public interface GySystemNoticeDao {

    /**
     * 公告
     * @return
     */
    List<GySystemNotice> list();

    /**
     * 分页数据
     * @param page
     * @param limit
     * @return
     */
    IPage<GySystemNotice> ipage(Integer page,Integer limit);

}
