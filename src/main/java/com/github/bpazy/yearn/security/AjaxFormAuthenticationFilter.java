package com.github.bpazy.yearn.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.bpazy.yearn.common.Result;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import static com.github.bpazy.yearn.common.Constants.NEED_LOGIN;

/**
 * @author ziyuan
 */
public class AjaxFormAuthenticationFilter extends FormAuthenticationFilter {
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Result result = Result.builder()
                .code(NEED_LOGIN)
                .message(NEED_LOGIN)
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        response.getWriter().write(objectMapper.writeValueAsString(result));
        return false;
    }
}
