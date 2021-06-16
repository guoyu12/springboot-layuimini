package com.anshark.controller;

import com.alibaba.fastjson.JSONObject;
import com.anshark.annotation.CheckLogin;
import com.anshark.controller.common.BaseController;
import com.anshark.model.GyUsers;
import com.anshark.response.ResultType;
import com.anshark.service.*;
import com.anshark.vo.UserTreeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    @Autowired
    private GyRolesService gyRolesService;
    @Autowired
    private GyDataStatisticsService gyDataStatisticsService;
    @Autowired
    private GySystemNoticeService gySystemNoticeService;

    @GetMapping("/index")
    public String index(HttpServletRequest request, Model model) {
        model.addAttribute("user", gyUsersService.findById(getUserId(request)));
        return "/admin/index";
    }

    @GetMapping("/home")
    public String home(HttpServletRequest request, Model model) {
        GyUsers byId = gyUsersService.findById(getUserId(request));
        model.addAttribute("uname", byId.getUsername());
        model.addAttribute("quickEntryList", gyMenusService.quickEntryList());
        model.addAttribute("data", JSONObject.toJSONString(gyDataStatisticsService.statistics()));
        model.addAttribute("notice", gySystemNoticeService.list());
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
    public ResultType list(HttpServletRequest request, String username, String phone, String email) {
        return gyUsersService.page(page(request), pageSize(request), username, phone, email);
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
        List<UserTreeVO> data = (List<UserTreeVO>) gyMenusService.userTree(id).getData();
        model.addAttribute("data", JSONObject.toJSONString(data));
        System.out.println(JSONObject.toJSONString(gyRolesService.dealEditData(id)));
        model.addAttribute("roles", gyRolesService.dealEditData(id));
        return "/admin/user/edit";
    }

    @RequestMapping("/editSubmit")
    @ResponseBody
    @CheckLogin(isCheck = true)
    public ResultType editSubmit(GyUsers gyUsers, String roles, String perms) {
        return gyUsersService.edit(gyUsers, roles, perms);
    }

    @RequestMapping("/add")
    public String add(Model model) {
        List<UserTreeVO> data = (List<UserTreeVO>) gyMenusService.userTree(null).getData();
        model.addAttribute("data", JSONObject.toJSONString(data));
        model.addAttribute("roles", gyRolesService.roles().getData());
        return "/admin/user/add";
    }

    @RequestMapping("/addSubmit")
    @ResponseBody
    @CheckLogin(isCheck = true)
    public ResultType addSubmit(GyUsers gyUsers, String roles, String perms) {
        return gyUsersService.addSubmit(gyUsers, roles, perms);
    }
}
