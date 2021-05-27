package com.anshark.exception;

import com.anshark.response.ResultState;
import com.anshark.response.ResultType;

/**
 * @Author GUOYU
 * @Date 2021/5/26
 * @Desc 系统异常
 */
public class SysException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    ResultType resultType;

    public ResultType getResultType() {
        return resultType;
    }

    public void setResultType(ResultType resultType) {
        this.resultType = resultType;
    }

    public SysException(ResultType resultType) {
        this.resultType = resultType;
    }

    public SysException(ResultState resultState) {
        this.resultType = new ResultType(resultState);
    }

    public SysException(String message) {
        super(message);
        this.resultType = new ResultType(ResultState.SYS_ERROR);
        resultType.setMsg(message);
    }
}
