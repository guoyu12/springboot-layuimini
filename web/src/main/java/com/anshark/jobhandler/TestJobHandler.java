package com.anshark.jobhandler;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author GUOYU
 * @Date 2021/5/27
 * @Desc
 */
@Component
public class TestJobHandler {

    @XxlJob("demoTestJobHandler")
    public void demoTestJobHandler() {
        XxlJobHelper.log("XXL-JOB, Hello World.");
        System.out.println("开始执行 " + new Date());
    }

}
