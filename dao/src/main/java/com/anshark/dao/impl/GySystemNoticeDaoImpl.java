package com.anshark.dao.impl;

import com.anshark.dao.GySystemNoticeDao;
import com.anshark.exception.SysException;
import com.anshark.mapper.GySystemNoticeMapper;
import com.anshark.model.GySystemNotice;
import com.anshark.response.ResultState;
import com.anshark.response.ResultType;
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
        queryWrapper.eq("is_deleted", 0);
        Page<GySystemNotice> page = new Page<>(1, 7);
        IPage<GySystemNotice> iPage = gySystemNoticeMapper.selectPage(page, queryWrapper);
        return iPage.getRecords();
    }

    @Override
    public IPage<GySystemNotice> ipage(Integer page, Integer limit) {
        Page<GySystemNotice> p = new Page<>(page, limit);
        IPage<GySystemNotice> iPage = gySystemNoticeMapper.selectPage(p, new QueryWrapper<GySystemNotice>().eq("is_deleted", 0));
        return iPage;
    }

    @Override
    public void save(GySystemNotice gySystemNotice) {
        gySystemNoticeMapper.insert(gySystemNotice);
    }

    @Override
    public void del(Integer id) {
        GySystemNotice gySystemNotice = gySystemNoticeMapper.selectById(id);
        if (null == gySystemNotice) {
            throw new SysException(ResultType.error("内容不存在"));
        }
        if (gySystemNotice.getIsDeleted() == 1) {
            throw new SysException(ResultType.error("内容已被删除"));
        }

        gySystemNotice.setIsDeleted(1);

        gySystemNoticeMapper.updateById(gySystemNotice);
    }

    @Override
    public GySystemNotice findById(Integer id) {
        return gySystemNoticeMapper.selectById(id);
    }

    @Override
    public void update(GySystemNotice gySystemNotice) {
        gySystemNoticeMapper.updateById(gySystemNotice);
    }
}
