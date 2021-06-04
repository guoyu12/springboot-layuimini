package com.anshark.controller.common;


import com.anshark.utils.SessionUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author GUOYU
 * @Date 2021/5/26
 * @Desc
 */
public class BaseController {

    public Integer getUserId(HttpServletRequest request) {
        return (Integer) SessionUtil.getSession(request, SessionUtil.USER_ID);
    }

}
