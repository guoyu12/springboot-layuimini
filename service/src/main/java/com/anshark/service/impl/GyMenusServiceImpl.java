package com.anshark.service.impl;

import com.anshark.dao.GyMenusDao;
import com.anshark.model.GyMenus;
import com.anshark.response.ResultType;
import com.anshark.service.GyMenusService;
import com.anshark.service.GyUserPermService;
import com.anshark.vo.MenuVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
        List<GyMenus> homeInfos = gyMenusDao.getMenusBy(0, 0, ids);
        map.put("homeInfo", homeInfos.size() > 0 ? homeInfos.get(0) : new GyMenus());

        //logo
        List<GyMenus> menusBys = gyMenusDao.getMenusBy(0, 1, ids);
        map.put("logoInfo", menusBys.size() > 0 ? menusBys.get(0) : new GyMenus());

        //菜单
        List<GyMenus> menuInfo = gyMenusDao.getMenusBy(0, 2, ids);
        for (GyMenus gyMenus : menuInfo) {
            deal(gyMenus.getId(), 2, gyMenus, ids);
        }
        map.put("menuInfo", menuInfo);

        return ResultType.success(map);
    }

    @Override
    public ResultType list() {

        List<GyMenus> list = gyMenusDao.list();
        return ResultType.success(getMenuList(list));
    }

    @Override
    public ResultType delete(Integer id) {
        if (null == id) {
            return ResultType.error("删除的ID不能为空");
        } else if (id == 0) {
            List<GyMenus> list = gyMenusDao.list();
            for (GyMenus gyMenus : list) {
                Integer delId = gyMenus.getId();
                if (delId > 7) {
                    gyMenus.setIsDeleted(true);
                    gyMenusDao.update(gyMenus);
                }
            }
        } else if (id >= 1 && id <= 7) {
            return ResultType.error("不允许删除");
        } else {
            delChildMenu(id);
        }
        return ResultType.success();
    }

    /**
     * 删除子菜单
     *
     * @param id
     */
    void delChildMenu(Integer id) {
        GyMenus gyMenus = gyMenusDao.findById(id);
        gyMenus.setIsDeleted(true);
        gyMenusDao.update(gyMenus);
        List<GyMenus> list = gyMenusDao.findByPid(id);
        for (GyMenus gm : list) {
            delChildMenu(gm.getId());
        }
    }

    public List<MenuVO> getMenuList(List<GyMenus> list) {
        List<MenuVO> menus = new ArrayList<>();
        MenuVO one = new MenuVO();
        one.setAuthorityId(0);
        one.setAuthorityName("权限管理");
        one.setOrderNumber(1);
        one.setMenuUrl(null);
        one.setMenuIcon("layui-icon-set");
        one.setCreateTime(LocalDateTime.now());
        one.setAuthority(null);
        one.setChecked(0);
        one.setUpdateTime(LocalDateTime.now());
        one.setIsMenu(0);
        one.setParentId(-1);
        menus.add(one);
        list.stream().forEach(s -> {
            MenuVO menu = new MenuVO();
            menu.setAuthorityId(s.getId());
            menu.setAuthorityName(s.getTitle());
            menu.setOrderNumber(s.getSort());
            menu.setMenuUrl(s.getHref());
            menu.setMenuIcon(s.getIcon());
            menu.setCreateTime(s.getCreateAt());
            menu.setAuthority(null);
            menu.setChecked(0);
            menu.setUpdateTime(s.getUpdateAt());
            menu.setIsMenu(s.getIsMenu());
            menu.setParentId(s.getParentId());
            menus.add(menu);
        });
        return menus;
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
