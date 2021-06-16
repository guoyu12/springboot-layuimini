package com.anshark.dao.impl;

import com.anshark.dao.GySystemNoticeDao;
import com.anshark.mapper.GySystemNoticeMapper;
import com.anshark.model.GySystemNotice;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author GUOYU
 * @Date 2021/6/16
 * @Desc
 */
@Repository
public class GySystemNoticeDaoImpl implements GySystemNoticeDao {

    @Autowired
    private GySystemNoticeMapper gySystemNoticeMapper;

    @Override
    public List<GySystemNotice> list() {
        QueryWrapper<GySystemNotice> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("create_at");
        Page<GySystemNotice> page = new Page<>(1, 7);
        IPage<GySystemNotice> iPage = gySystemNoticeMapper.selectPage(page, queryWrapper);
        return iPage.getRecords();
    }

    @Override
    public IPage<GySystemNotice> ipage(Integer page, Integer limit) {
        Page<GySystemNotice> p = new Page<>(page, limit);
        IPage<GySystemNotice> iPage = gySystemNoticeMapper.selectPage(p, new QueryWrapper<>());
        return iPage;
    }
}
