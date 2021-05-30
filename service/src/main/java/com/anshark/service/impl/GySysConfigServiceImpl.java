package com.anshark.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.anshark.dao.GySysConfigDao;
import com.anshark.model.GySysConfig;
import com.anshark.po.SysConfigPO;
import com.anshark.response.ResultType;
import com.anshark.service.GySysConfigService;
import com.anshark.utils.ClassUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @version 1.0
 * @Author GUOYU
 * @date 2021/5/30 15:47
 */
@Service
public class GySysConfigServiceImpl implements GySysConfigService {

    @Autowired
    private GySysConfigDao gySysConfigDao;

    @Override
    public ResultType list() {
        return ResultType.success(gySysConfigDao.list());
    }

    @Override
    public ResultType submit(SysConfigPO sysConfigPO) {
        Map<String, Object> map = ClassUtils.getEntity(sysConfigPO);
        System.out.println(JSONObject.toJSONString(map));
        Set<Map.Entry<String, Object>> entries = map.entrySet();
        Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> next = iterator.next();

            GySysConfig byCfgName = gySysConfigDao.findByCfgName(next.getKey());

            byCfgName.setCfgValue(next.getValue().toString());

            gySysConfigDao.update(byCfgName);

        }


        return ResultType.success();
    }
}
