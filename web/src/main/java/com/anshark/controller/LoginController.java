package com.anshark.controller;

import com.anshark.controller.common.BaseController;
import com.anshark.response.ResultType;
import com.anshark.service.GyUsersService;
import com.anshark.utils.VerifyCodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author GUOYU
 * @Date 2021/5/26
 * @Desc
 */
@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController extends BaseController {

    @Autowired
    private GyUsersService gyUsersService;


    /**
     * 登录页
     */
    @GetMapping("/page")
    public String page() {
        return "/admin/login";
    }

    /**
     * @param username
     * @param password
     * @param captcha    图形验证码
     * @param rememberMe 是否记住我
     * @return
     */
    @PostMapping("/submit")
    @ResponseBody
    public ResultType submit(String username, String password, String captcha, @RequestParam(defaultValue = "false") Boolean rememberMe, HttpServletRequest request) {
        return gyUsersService.login(username, password, captcha, rememberMe, request);
    }

    @GetMapping("/getVerifyCode")
    public void getVerifyCode(HttpServletRequest request, HttpServletResponse response) {
        //设置相应类型,告诉浏览器输出的内容为图片
        response.setContentType("image/jpeg");
        //设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        new VerifyCodeUtil().getRandcode(request, response);
    }


}
