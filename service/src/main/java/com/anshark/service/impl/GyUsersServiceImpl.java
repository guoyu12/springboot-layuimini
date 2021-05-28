package com.anshark.service.impl;

import com.anshark.common.Constant;
import com.anshark.dao.GyUsersDao;
import com.anshark.model.GyUsers;
import com.anshark.response.ResultType;
import com.anshark.service.GyUsersService;
import com.anshark.utils.JwtUtils;
import com.anshark.utils.Md5Utils;
import com.anshark.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.concurrent.TimeUnit;

/**
 * @Author GUOYU
 * @Date 2021/5/26
 * @Desc
 */
@Service
public class GyUsersServiceImpl implements GyUsersService {

    @Autowired
    private GyUsersDao gyUsersDao;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Override
    public ResultType login(String username, String password, String captcha, Boolean rememberMe, HttpServletRequest request) {

        GyUsers gyUsers = gyUsersDao.findByUsername(username);

        if (null == gyUsers) {
            return ResultType.error("用户不存在");
        }

        String realPassword = gyUsers.getPassword();
        if (!realPassword.equals(Md5Utils.md5(password))) {
            return ResultType.error("密码错误");
        }

        HttpSession session = request.getSession();

        Object captchaCode = session.getAttribute(Constant.CAPTCHA_CODE);
        if (null == captchaCode) {
            return ResultType.error("验证码已失效");
        }

        if (!captchaCode.toString().equalsIgnoreCase(captcha)) {
            return ResultType.error("验证码错误");
        }

        String token = JwtUtils.createToken(gyUsers.getId());

        String tokenKey = String.format(Constant.GYADMIN_TOKEN, gyUsers.getId());

        if (rememberMe) {
            stringRedisTemplate.opsForValue().set(tokenKey, token, 7, TimeUnit.DAYS);
        } else {
            SessionUtil.setSession(request, tokenKey, token);
        }

        return ResultType.success(token);
    }

    @Override
    public ResultType logout(HttpServletRequest request, Integer userId) {
        boolean loginWayRemeberMe = SessionUtil.getIsRemeberMe(request);
        String tokenKey = String.format(Constant.GYADMIN_TOKEN, userId);

        if (loginWayRemeberMe) {
            stringRedisTemplate.delete(tokenKey);
        } else {
            String session = (String) SessionUtil.getSession(request, tokenKey);
            if (null != session) {
                //移除
                SessionUtil.remove(request, tokenKey);
            }
        }
        return ResultType.success();
    }
}
