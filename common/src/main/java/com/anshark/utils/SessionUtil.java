package com.anshark.utils;

import com.anshark.common.Constant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author GUOYU
 * @Date 2021/5/27
 * @Desc
 */
public class SessionUtil {


    public static final String REMEMBER_ME_TRUE = "true";
    public static final String REMEMBER_ME_FALSE = "false";

    public static final String USER_ID = "USER_ID";

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
        HttpSession session = request.getSession();
        Integer attribute = (Integer) session.getAttribute(name);
        if (null == attribute) {
            session.setAttribute(name, value);
        }
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
