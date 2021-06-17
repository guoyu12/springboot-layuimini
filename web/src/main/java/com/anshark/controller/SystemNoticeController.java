package com.anshark.controller;

import com.anshark.controller.common.BaseController;
import com.anshark.model.GySystemNotice;
import com.anshark.response.ResultType;
import com.anshark.service.GySystemNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("/list")
    @ResponseBody
    public ResultType list(HttpServletRequest request) {
        return gySystemNoticeService.page(page(request), pageSize(request));
    }

    @RequestMapping("/addPage")
    public String addPage() {
        return "/admin/notice/addNotice";
    }

    @ResponseBody
    @PostMapping("/addSubmit")
    public ResultType addSubmit(GySystemNotice gySystemNotice) {
        return gySystemNoticeService.addSubmit(gySystemNotice);
    }

    @ResponseBody
    @PostMapping("/del")
    public ResultType del(Integer id) {
        return gySystemNoticeService.del(id);
    }

    @RequestMapping("/editPage")
    public String editPage(Integer id, Model model) {
        model.addAttribute("notice", gySystemNoticeService.findById(id));
        return "/admin/notice/editNotice";
    }

    @PostMapping("/editSubmit")
    @ResponseBody
    public ResultType editSubmit(GySystemNotice gySystemNotice) {
        return gySystemNoticeService.update(gySystemNotice);
    }

}
