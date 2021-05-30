package com.anshark.controller;

import com.alibaba.fastjson.JSONObject;
import com.anshark.annotation.CheckLogin;
import com.anshark.model.GyMenus;
import com.anshark.response.ResultType;
import com.anshark.service.GyMenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @ResponseBody
    @RequestMapping("/list")
    @CheckLogin(isCheck = true)
    public ResultType list() {
        System.out.println(JSONObject.toJSONString(gyMenusService.list()));
        return gyMenusService.list();
    }

    @ResponseBody
    @PostMapping("/delete")
    @CheckLogin(isCheck = true)
    public ResultType delete(Integer id) {
        return gyMenusService.delete(id);
    }

    @GetMapping("/editPage")
    public String editPage(Integer id, Model model) {
        model.addAttribute("menu", gyMenusService.findById(id));
        List<GyMenus> list = (List<GyMenus>) gyMenusService.all().getData();
        List<GyMenus> newList = list.stream().filter(s -> s.getId() != id).collect(Collectors.toList());
        model.addAttribute("pList", newList);
        return "/admin/menu/edit";
    }

}
