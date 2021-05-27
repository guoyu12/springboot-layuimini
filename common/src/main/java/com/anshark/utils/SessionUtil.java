package com.anshark.utils;

import com.anshark.common.Constant;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author GUOYU
 * @Date 2021/5/27
 * @Desc
 */
public class SessionUtil {

    public static final String IS_REMEBER_ME_TRUE = "true";

    public static final String IS_REMEBER_ME_FALSE = "false";

    public static String getHeader(HttpServletRequest request, String name) {
        return request.getHeader(name);
    }

    public static String getSession(HttpServletRequest request, String name) {
        return (String) request.getSession().getAttribute(name);
    }

    public static void remove(HttpServletRequest request, String name) {
        request.getSession().removeAttribute(name);
    }

    public static void setSession(HttpServletRequest request, String name, String value) {
        request.getSession().setAttribute(name, value);
    }

    public static String getIsRemeberMe(HttpServletRequest request) {
        return getSession(request, Constant.LOGIN_WAY_REMEBER_ME);
    }


}
