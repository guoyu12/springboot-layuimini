package com.anshark.controller;

import com.anshark.annotation.CheckLogin;
import com.anshark.response.ResultType;
import com.anshark.service.GyMenusService;
import com.anshark.service.GyUsersService;
import com.anshark.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author GUOYU
 * @Date 2021/5/26
 * @Desc
 */
@RequestMapping("/users")
@Controller
public class UsersController {

    @Autowired
    private GyMenusService gyMenusService;
    @Autowired
    private GyUsersService gyUsersService;

    @GetMapping("/index")
    public String index() {
        return "/admin/index";
    }

    @PostMapping("/indexData")
    @ResponseBody
    @CheckLogin(isCheck = true)
    public ResultType indexData() {
        return gyMenusService.getMenus(UserUtils.getUserId());
    }

    @PostMapping("/logout")
    @ResponseBody
    @CheckLogin(isCheck = true)
    public ResultType logout(HttpServletRequest request) {
        return gyUsersService.logout(request, UserUtils.getUserId());
    }

}
