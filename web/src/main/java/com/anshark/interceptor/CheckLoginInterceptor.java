package com.anshark.interceptor;


import com.anshark.annotation.CheckLogin;
import com.anshark.common.Constant;
import com.anshark.dao.GyUsersDao;
import com.anshark.exception.SysException;
import com.anshark.model.GyUsers;
import com.anshark.response.ResultState;
import com.anshark.utils.JwtUtils;
import com.anshark.utils.SessionUtil;
import com.anshark.utils.UserUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author GUOYU
 * @Date 2021/5/26
 * @Desc
 */
@Configuration
@Slf4j
public class CheckLoginInterceptor implements HandlerInterceptor {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private GyUsersDao gyUsersDao;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        log.info("【CheckLoginInterceptor】 【preHandle】 url -- " + request.getRequestURI());

        boolean isNeedCheck = true;

        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            CheckLogin typeAnnotation = handlerMethod.getMethod().getDeclaringClass().getAnnotation(CheckLogin.class);
            if (null == typeAnnotation || !typeAnnotation.isCheck()) {
                CheckLogin methodAnnotation = handlerMethod.getMethod().getAnnotation(CheckLogin.class);
                if (null == methodAnnotation || !methodAnnotation.isCheck()) {
                    //至此不用检查登录状态
                    isNeedCheck = false;
                }
            }
        }


        log.info("【CheckLoginInterceptor】 【preHandle】 isNeedCheck -- {}", isNeedCheck);

        if (isNeedCheck) {

            boolean loginWayRemeberMe = SessionUtil.getIsRemeberMe(request);
            log.info("【CheckLoginInterceptor】 【preHandle】 loginWayRemeberMe -- {}", loginWayRemeberMe);

            String gyAdminToken = SessionUtil.getHeader(request, Constant.GYADMIN_TOKEN_COOKIE);

            log.info("【CheckLoginInterceptor】 【preHandle】 token -- {}", gyAdminToken);

            Integer reqUserId = JwtUtils.getUserId(gyAdminToken);

            Integer userId = getUserId(reqUserId, loginWayRemeberMe, request);

            checkUserId(userId);

            SessionUtil.setSession(request, SessionUtil.USER_ID, userId);

            UserUtils.set(userId);

        }

        return true;
    }

    void checkUserId(Integer userId) {
        GyUsers gyUsers = gyUsersDao.findById(userId);

        if (null == gyUsers) {
            throw new SysException(ResultState.SYS_EXIT);
        }
    }

    Integer getUserId(Integer userId, boolean loginWayRemeberMe, HttpServletRequest request) {

        String tokenKey = String.format(Constant.GYADMIN_TOKEN, userId);

        if (!loginWayRemeberMe) {
            String header = (String) request.getSession().getAttribute(tokenKey);
            if (StringUtils.isEmpty(header)) {
                throw new SysException(ResultState.SYS_EXIT);
            }
            return JwtUtils.getUserId(header);
        } else if (loginWayRemeberMe) {
            String val = stringRedisTemplate.opsForValue().get(tokenKey);
            if (StringUtils.isEmpty(val)) {
                throw new SysException(ResultState.SYS_EXIT);
            }
            return JwtUtils.getUserId(val);
        }

        throw new SysException(ResultState.SYS_EXIT);

    }


}
