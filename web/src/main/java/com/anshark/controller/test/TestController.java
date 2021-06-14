package com.anshark.controller.test;

import com.alibaba.fastjson.JSONObject;
import com.anshark.common.Constant;
import com.anshark.exception.SysException;
import com.anshark.model.GyUsers;
import com.anshark.netty.websocket.handler.CustomerSocketHandler;
import com.anshark.response.ResultType;
import com.anshark.service.GyMenusService;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;
import java.util.Map;

/**
 * @Author GUOYU
 * @Date 2021/5/26
 * @Desc
 */
@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Autowired
    private GyMenusService gyMenusService;

    @ResponseBody
    @RequestMapping("/test")
    public String test() {
        Map<String, Channel> map = CustomerSocketHandler.map;
        log.info("ChannelHandlerContext === " +map.size());
        Iterator<Map.Entry<String, Channel>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Channel> next = iterator.next();
            Channel value = next.getValue();
            value.writeAndFlush(new TextWebSocketFrame(JSONObject.toJSONString(ResultType.success("sadasd"))));
        }

        return "success";
    }

//    @RequestMapping("/index")
//    public String test() {
//        return "/admin/index";
//    }

    @ResponseBody
    @RequestMapping("/body")
    public ResultType body(String username, String password, Integer id) {
        if (id == 0) {
            throw new SysException(ResultType.error("错误信息"));
        }
        if (id == 1) {
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
