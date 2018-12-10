package com.github.bpazy.yearn.security;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author ziyuan
 */
@NoArgsConstructor
@AllArgsConstructor
public class UsernamePasswordToken implements AuthenticationToken {
    private String username;
    private String password;

    @Override
    public Object getPrincipal() {
        return username;
    }

    @Override
    public Object getCredentials() {
        return password;
    }
}
