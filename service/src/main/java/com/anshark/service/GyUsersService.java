package com.anshark.service;

import com.anshark.model.GyUsers;
import com.anshark.response.ResultType;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author GUOYU
 * @Date 2021/5/26
 * @Desc
 */
public interface GyUsersService {

    /**
     * 登录
     *
     * @param username
     * @param password
     * @param captcha
     * @param rememberMe
     * @param request
     * @return
     */
    ResultType login(String username, String password, String captcha, Boolean rememberMe, HttpServletRequest request);

    /**
     * 退出
     *
     * @param userId
     * @param request
     * @return
     */
    ResultType logout(HttpServletRequest request, Integer userId);

    /**
     *
     * @param id
     * @return
     */
    GyUsers findById(Integer id);

    /**
     * 修改密码
     * @param userId
     * @param password
     * @param newPassword
     * @param retrePassword
     * @return
     */
    ResultType editPass(Integer userId,String password, String newPassword,String retrePassword);

}
