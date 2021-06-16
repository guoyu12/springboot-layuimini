package com.anshark.service;

import com.anshark.model.GyRoles;
import com.anshark.response.ResultType;

import java.util.List;

/**
 * @Author GUOYU
 * @Date 2021/6/11
 * @Desc
 */
public interface GyRolesService {

    ResultType roles();

    /**
     * 处理数据
     * @param userId
     * @return
     */
    List<GyRoles> dealEditData(Integer userId);

}
