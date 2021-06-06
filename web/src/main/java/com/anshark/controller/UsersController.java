package com.anshark.controller;

import com.anshark.annotation.CheckLogin;
import com.anshark.controller.common.BaseController;
import com.anshark.model.GyUsers;
import com.anshark.response.ResultType;
import com.anshark.service.GyMenusService;
import com.anshark.service.GyUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class UsersController extends BaseController {

    @Autowired
    private GyMenusService gyMenusService;
    @Autowired
    private GyUsersService gyUsersService;

    @GetMapping("/index")
    public String index() {
        return "/admin/index";
    }

    @GetMapping("/home")
    public String home() {
        return "/admin/home/home";
    }

    @PostMapping("/indexData")
    @ResponseBody
    @CheckLogin(isCheck = true)
    public ResultType indexData(HttpServletRequest request) {
        return gyMenusService.getMenus(getUserId(request));
    }

    @PostMapping("/logout")
    @ResponseBody
    @CheckLogin(isCheck = true)
    public ResultType logout(HttpServletRequest request) {
        return gyUsersService.logout(request, getUserId(request));
    }

    @GetMapping("/setting")
    public String setting(HttpServletRequest request, Model model) {
        Integer userId = getUserId(request);
        model.addAttribute("user", gyUsersService.findById(userId));
        return "/admin/user/userSetting";
    }

    @PostMapping("/settingSubmit")
    @ResponseBody
    @CheckLogin(isCheck = true)
    public ResultType settingSubmit(GyUsers gyUsers, HttpServletRequest request) {
        gyUsers.setId(getUserId(request));
        return gyUsersService.save(gyUsers);
    }


    @GetMapping("/editPass")
    public String editPass() {
        return "/admin/user/editPass";
    }

    /**
     * @param password      旧密码
     * @param newPassword
     * @param retrePassword
     * @return
     */
    @PostMapping("/editPassSubmit")
    @ResponseBody
    public ResultType resultType(String password, String newPassword, String retrePassword, HttpServletRequest request) {
        return gyUsersService.editPass(getUserId(request), password, newPassword, retrePassword);
    }

    @RequestMapping("/list")
    @ResponseBody
    public ResultType list(HttpServletRequest request) {
        return gyUsersService.page(page(request), pageSize(request));
    }

    @GetMapping("/userPage")
    public String userPage() {
        return "/admin/user/userList";
    }

    @RequestMapping("/del")
    @ResponseBody
    @CheckLogin(isCheck = true)
    public ResultType del(Integer id) {
        return gyUsersService.del(id);
    }

    @RequestMapping("/editPage")
    public String editPage(Integer id, Model model) {
        GyUsers user = gyUsersService.findById(id);
        model.addAttribute("user", user);
        return "/admin/user/edit";
    }

    @RequestMapping("/editSubmit")
    @ResponseBody
    @CheckLogin(isCheck = true)
    public ResultType editSubmit(GyUsers gyUsers) {
        return gyUsersService.edit(gyUsers);
    }
}
