package com.anshark.controller;

import com.anshark.annotation.CheckLogin;
import com.anshark.po.SysConfigPO;
import com.anshark.response.ResultType;
import com.anshark.service.GySysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @version 1.0
 * @Author GUOYU
 * @date 2021/5/30 15:45
 */
@Controller
@RequestMapping("/sysConfig")
public class GySysConfigController {

    @Autowired
    private GySysConfigService gySysConfigService;

    @GetMapping("/setting")
    public String setting(){
        return "/admin/setting/setting";
    }

    @PostMapping("/list")
    @ResponseBody
    @CheckLogin(isCheck = true)
    public ResultType list() {
        return gySysConfigService.list();
    }

    @PostMapping("/submit")
    @ResponseBody
    @CheckLogin(isCheck = true)
    public ResultType submit(SysConfigPO sysConfigPO) {
        return gySysConfigService.submit(sysConfigPO);
    }

}
