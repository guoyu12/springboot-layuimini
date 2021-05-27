package com.anshark.controller.test;

import com.anshark.exception.SysException;
import com.anshark.model.GyUsers;
import com.anshark.response.ResultType;
import com.anshark.service.GyMenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author GUOYU
 * @Date 2021/5/26
 * @Desc
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private GyMenusService gyMenusService;

    @RequestMapping("/index")
    public String test() {
        return "/admin/index";
    }

    @ResponseBody
    @RequestMapping("/body")
    public ResultType body(String username, String password,Integer id) {
        if(id == 0){
            throw new SysException(ResultType.error("错误信息"));
        }
        if(id == 1){
            int i = 1 / 0;
        }
        return ResultType.success(username + password);
    }

    @ResponseBody
    @PostMapping("json")
    public ResultType body(@RequestBody GyUsers gyUsers) {
        return ResultType.success(gyUsers);
    }


//    @RequestMapping("indexData")
//    @ResponseBody
//    @CheckLogin(isCheck = true)
//    public ResultType indexData() {
//        return gyMenusService.getMenus(UserUtils.getUserId());
//    }

}
