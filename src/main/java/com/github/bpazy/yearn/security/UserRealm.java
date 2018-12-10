package com.github.bpazy.yearn.security;

import com.github.bpazy.yearn.service.UserService;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ziyuan
 */
public class UserRealm extends AuthorizingRealm {

    @Override
    public String getName() {
        return UserRealm.class.getSimpleName();
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        String password = (String) token.getCredentials();
        if (!"bpazy".equals(username)) throw new UnknownAccountException("username not exists");
        if (!"123456".equals(password)) throw new IncorrectCredentialsException("password is incorrect");

        return new SimpleAuthenticationInfo(username, password, getName());
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        if (principals == null || StringUtils.isBlank((String) principals.getPrimaryPrincipal())) {
            return null;
        }
        return new SimpleAuthorizationInfo(Sets.newHashSet("blog:save", "blog:delete"));
    }
}
