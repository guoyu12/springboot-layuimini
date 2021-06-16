package com.anshark.controller;

import com.anshark.controller.common.BaseController;
import com.anshark.response.ResultType;
import com.anshark.service.GySystemNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author GUOYU
 * @Date 2021/6/16
 * @Desc
 */
@Controller
@RequestMapping("/notice")
public class SystemNoticeController extends BaseController {

    @Autowired
    private GySystemNoticeService gySystemNoticeService;

    @RequestMapping("/page")
    public String page() {
        return "/admin/notice/noticeList";
    }

    @PostMapping("/list")
    public ResultType list(HttpServletRequest request) {
        return gySystemNoticeService.page(page(request), pageSize(request));
    }

}
