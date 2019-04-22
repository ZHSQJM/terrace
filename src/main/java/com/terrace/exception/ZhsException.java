package com.terrace.exception;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @project: zblog
 * @author: zhs
 * @date: 2019/3/28 14:25
 * @package: com.zblog.exception
 * @description: 自定义异常
 */
@Data
@Slf4j
public class ZhsException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String msg;

    public ZhsException(String msg) {
         this.msg = msg;
    }
}
