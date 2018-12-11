package com.github.bpazy.yearn.security;

import com.github.bpazy.yearn.common.Springs;
import com.github.bpazy.yearn.po.User;
import com.github.bpazy.yearn.service.UserService;
import org.apache.shiro.SecurityUtils;

/**
 * @author ziyuan
 */
public class UserStatic {
    public static User getUser() {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        return Springs.getBean(UserService.class).findUserByUsername(username);
    }
}
