package com.anshark.config;

import com.alibaba.fastjson.JSONObject;
import com.anshark.dao.GyRequestLogDao;
import com.anshark.exception.SysException;
import com.anshark.model.GyRequestLog;
import com.anshark.response.ResultState;
import com.anshark.response.ResultType;
import com.anshark.utils.HttpRequestUtils;
import com.anshark.utils.IpUtils;
import com.anshark.utils.UserUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * @Author GUOYU
 * @Date 2021/5/26
 * @Desc 全局异常
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler implements ResponseBodyAdvice<Object> {

    @Autowired
    private GyRequestLogDao gyRequestLogDao;

    /**
     * 响应信息
     */
    public static final String EXCEPTION = "exception";

    public static final String ERR_MSG = "errMsg";

    /**
     * 500 - Bad Request
     */
    @ExceptionHandler({HttpMessageNotReadableException.class,
            HttpRequestMethodNotSupportedException.class,
            HttpMediaTypeNotSupportedException.class,
            SQLException.class,
            NullPointerException.class, Exception.class})
    @ResponseBody
    public ResultType handleHttpMessageNotReadableException(HttpServletRequest request,
                                                            HttpServletResponse response,
                                                            Exception e) {

        log.error("【GlobalExceptionHandler】【handleHttpMessageNotReadableException】 -> {}", printException(e));
        request.setAttribute(EXCEPTION, printException(e));
        request.setAttribute(ERR_MSG, e.getMessage());
        return new ResultType(ResultState.SYS_ERROR);
    }

    /**
     * 404 处理
     */


    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ResponseBody
    public ResultType notFound(HttpServletRequest request, Exception e) {
        log.error("【GlobalExceptionHandler】【notFound】 -> {}", printException(e));
        request.setAttribute(EXCEPTION, e.toString());
        request.setAttribute(ERR_MSG, ResultState.SYS_UNKOWN_PATH.getMsg());
        return new ResultType(ResultState.SYS_UNKOWN_PATH);
    }

    /**
     * 系统自定异常信息处理
     *
     * @return
     */
    @ExceptionHandler(SysException.class)
    @ResponseBody
    public ResultType sysException(HttpServletRequest request, SysException ex) {
        log.error("【GlobalExceptionHandler】【sysException】 -> {}", printException(ex));
        request.setAttribute(EXCEPTION, ex.toString());
        request.setAttribute(ERR_MSG, ex.getResultType().getMsg());
        return ex.getResultType();
    }


    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        HttpServletRequest request = HttpRequestUtils.getRequest();

        GyRequestLog gyRequestLog = new GyRequestLog();
        gyRequestLog.setTraceStack((String) request.getAttribute(EXCEPTION));
        gyRequestLog.setResponseMsg((String) request.getAttribute(ERR_MSG));
        gyRequestLog.setRequestUri(request.getRequestURI());
        gyRequestLog.setUserId(UserUtils.getUserId());
        gyRequestLog.setCreateAt(LocalDateTime.now());
        String requestParam = null;
        Map<String, String[]> parameterMap = request.getParameterMap();
        if (null != parameterMap) {
            requestParam = JSONObject.toJSONString(parameterMap);
        }
        gyRequestLog.setRequestParam(requestParam);
        gyRequestLog.setResponseData(JSONObject.toJSONString(o));
        gyRequestLog.setCode(((ResultType) o).getCode());
        gyRequestLog.setIpAddr(IpUtils.getIp(request));

        gyRequestLogDao.save(gyRequestLog);
        return o;
    }


    private String printException(Throwable e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        e.printStackTrace(pw);
        pw.flush();
        sw.flush();
        return sw.toString();
    }
}
