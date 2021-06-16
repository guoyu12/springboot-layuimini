package com.anshark.service.impl;

import com.anshark.dao.GySystemNoticeDao;
import com.anshark.model.GySystemNotice;
import com.anshark.response.ResultType;
import com.anshark.service.GySystemNoticeService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author GUOYU
 * @Date 2021/6/16
 * @Desc
 */
@Service
public class GySystemNoticeServiceImpl implements GySystemNoticeService {

    @Autowired
    private GySystemNoticeDao gySystemNoticeDao;

    @Override
    public List<GySystemNotice> list() {
        return gySystemNoticeDao.list();
    }

    @Override
    public ResultType page(Integer page, Integer limit) {
        IPage<GySystemNotice> ipage = gySystemNoticeDao.ipage(page, limit);
        return ResultType.success(ipage.getRecords(), (int)ipage.getTotal());
    }
}
