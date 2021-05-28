package com.anshark.controller;

import com.anshark.response.ResultType;
import com.anshark.service.GyMenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author GUOYU
 * @Date 2021/5/26
 * @Desc
 */
@Controller
@RequestMapping("/gyMenus")
public class GyMenusController {

    @Autowired
    private GyMenusService gyMenusService;

    @RequestMapping("/list")
    @ResponseBody
    public ResultType list(){
        return gyMenusService.list();
    }

}
