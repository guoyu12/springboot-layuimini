package com.anshark.utils;

import com.anshark.common.Constant;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author GUOYU
 * @Date 2021/5/27
 * @Desc
 */
public class SessionUtil {


    public static final String REMEMBER_ME_TRUE = "true";
    public static final String REMEMBER_ME_FALSE = "false";

    public static String getHeader(HttpServletRequest request, String name) {
        return request.getHeader(name);
    }

    public static Object getSession(HttpServletRequest request, String name) {
        return request.getSession().getAttribute(name);
    }

    public static void remove(HttpServletRequest request, String name) {
        request.getSession().removeAttribute(name);
    }

    public static void setSession(HttpServletRequest request, String name, Object value) {
        request.getSession().setAttribute(name, value);
    }

    public static boolean getIsRemeberMe(HttpServletRequest request) {
        return rememberMe(getHeader(request, Constant.LOGIN_WAY_REMEBER_ME));
    }

    public static boolean rememberMe(String session) {
        if (null != session && REMEMBER_ME_TRUE.equals(session)) {
            return true;
        }
        return false;
    }

}
