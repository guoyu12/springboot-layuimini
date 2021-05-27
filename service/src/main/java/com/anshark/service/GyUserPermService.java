package com.anshark.service;

import java.util.List;

/**
 * @Author GUOYU
 * @Date 2021/5/27
 * @Desc
 */
public interface GyUserPermService {

    /**
     * 获取用户拥有的权限
     * @param userId
     * @return
     */
    List<Integer> getPerms(Integer userId);

}
