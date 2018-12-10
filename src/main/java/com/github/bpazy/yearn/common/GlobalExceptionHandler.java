package com.github.bpazy.yearn.common;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ziyuan
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(BusinessException.class)
    public Result businessExceptionHandler(BusinessException e) {
        return ResultGenerator.fail(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(AuthorizationException.class)
    public Result authorizationExceptionHandler(AuthorizationException e) {
        return ResultGenerator.fail(e.getMessage());
    }
}
