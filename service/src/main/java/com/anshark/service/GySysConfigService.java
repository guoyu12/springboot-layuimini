package com.anshark.service;

import com.anshark.po.SysConfigPO;
import com.anshark.response.ResultType;

/**
 * @version 1.0
 * @Author GUOYU
 * @date 2021/5/30 15:46
 */
public interface GySysConfigService {

    /**
     * 获取配置集合
     * @return
     */
    ResultType list();

    /**
     * 更新配置
     * @param sysConfigPO
     * @return
     */
    ResultType submit(SysConfigPO sysConfigPO);
}
