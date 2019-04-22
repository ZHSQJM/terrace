package com.terrace.exception;

import com.terrace.vo.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @project: zblog
 * @author: zhs
 * @date: 2019/3/26 10:17
 * @package: com.zblog.exception
 * @description: 全局异常捕获
 */

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 数据校验异常
     * @param ex
     * @return
     */
    @ExceptionHandler(value = BindException.class)
    public ResultData bindExceptionErrorHandler(BindException ex) {
        StringBuilder sb = new StringBuilder();
        FieldError fieldError = ex.getFieldError();
        sb.append(fieldError.getDefaultMessage());
        return ResultData.error(sb.toString());
    }


    /**
     * 自定义异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = ZhsException.class)
    public ResultData HandleZhsException(ZhsException e) {
        return ResultData.error(e.getMsg());
    }


    @ExceptionHandler(value = Exception.class)
    public ResultData HandleException(Exception e){
        e.printStackTrace();
        return ResultData.error("系统错误，请联系管理员");
    }

}
