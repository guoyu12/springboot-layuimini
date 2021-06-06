package com.anshark.controller.common;


import com.anshark.utils.SessionUtil;
import org.apache.commons.lang3.StringUtils;

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

    public Integer page(HttpServletRequest request) {
        String page = request.getParameter("page");
        if(StringUtils.isEmpty(page)){
            return 1;
        }
        return Integer.parseInt(page);
    }

    public Integer pageSize(HttpServletRequest request){
        String limit = request.getParameter("limit");
        if(StringUtils.isEmpty(limit)){
            return 10;
        }
        return Integer.parseInt(limit);
    }

}
