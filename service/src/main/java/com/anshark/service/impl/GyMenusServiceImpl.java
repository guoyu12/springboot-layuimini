package com.anshark.service.impl;

import com.anshark.dao.GyMenusDao;
import com.anshark.model.GyMenus;
import com.anshark.response.ResultType;
import com.anshark.service.GyMenusService;
import com.anshark.service.GyUserPermService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author GUOYU
 * @Date 2021/5/26
 * @Desc
 */
@Slf4j
@Service
public class GyMenusServiceImpl implements GyMenusService {

    @Autowired
    private GyMenusDao gyMenusDao;
    @Autowired
    private GyUserPermService gyUserPermService;

    @Override
    public ResultType getMenus(Integer userId) {

        log.info("【GyMenusServiceImpl】【getMenus】 userId -- {}", userId);

        Map<String, Object> map = new HashMap<>(3);

        List<Integer> ids = getIds(userId);

        //首页
        GyMenus homeInfo = gyMenusDao.getMenusBy(0, 0, ids).get(0);
        map.put("homeInfo", homeInfo);

        //logo
        GyMenus logoInfo = gyMenusDao.getMenusBy(0, 1, ids).get(0);
        map.put("logoInfo", logoInfo);

        //菜单
        List<GyMenus> menuInfo = gyMenusDao.getMenusBy(0, 2, ids);
        for (GyMenus gyMenus : menuInfo) {
            deal(gyMenus.getId(), 2, gyMenus, ids);
        }
        map.put("menuInfo", menuInfo);

        return ResultType.success(map);
    }


    /**
     * 处理菜单栏关系
     *
     * @param pid
     * @param gyMenus
     */
    void deal(Integer pid, Integer type, GyMenus gyMenus, List<Integer> ids) {
        List<GyMenus> list = gyMenusDao.getMenusBy(pid, type, ids);
        if (list.size() > 0) {
            gyMenus.setChild(list);
            for (int i = 0; i < list.size(); i++) {
                GyMenus child = list.get(i);
                deal(child.getId(), type, child, ids);
            }
        }
    }

    /**
     * 处理菜单栏权限 mybatisplus in 查询
     *
     * @return
     */
    List<Integer> getIds(Integer userId) {
        List<Integer> perms = gyUserPermService.getPerms(userId);
        if (perms.size() == 0) {
            perms.add(0);
        }
        return perms;
    }


}
