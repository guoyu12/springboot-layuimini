package com.anshark.controller;

import com.anshark.annotation.CheckLogin;
import com.anshark.po.SysConfigPO;
import com.anshark.response.ResultType;
import com.anshark.service.GySysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @Author GUOYU
 * @date 2021/5/30 15:45
 */
@RestController
@RequestMapping("/sysConfig")
@CheckLogin(isCheck = true)
public class GySysConfigController {

    @Autowired
    private GySysConfigService gySysConfigService;


    @PostMapping("/list")
    public ResultType list() {
        return gySysConfigService.list();
    }

    @PostMapping("/submit")
    public ResultType submit(SysConfigPO sysConfigPO) {
        return gySysConfigService.submit(sysConfigPO);
    }

}
