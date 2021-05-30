package com.anshark.controller;

import com.alibaba.fastjson.JSONObject;
import com.anshark.annotation.CheckLogin;
import com.anshark.response.ResultType;
import com.anshark.service.GyMenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author GUOYU
 * @Date 2021/5/26
 * @Desc
 */
@RestController
@RequestMapping("/gyMenus")
@CheckLogin(isCheck = true)
public class GyMenusController {

    @Autowired
    private GyMenusService gyMenusService;

    @RequestMapping("/list")
    public ResultType list(){
        System.out.println(JSONObject.toJSONString(gyMenusService.list()));
        return gyMenusService.list();
    }

    @PostMapping("/delete")
    public ResultType delete(Integer id){
        return gyMenusService.delete(id);
    }

}
