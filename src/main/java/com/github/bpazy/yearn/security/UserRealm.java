package com.github.bpazy.yearn.security;

import com.github.bpazy.yearn.po.User;
import com.github.bpazy.yearn.service.UserService;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ziyuan
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

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
        User user = userService.findUserByUsername(username);
        if (user == null) throw new UnknownAccountException("username not exists");

        return new SimpleAuthenticationInfo(username, user.getPassword(), ByteSource.Util.bytes("hcrf"), getName());
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        if (principals == null || StringUtils.isBlank((String) principals.getPrimaryPrincipal())) {
            return null;
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(Sets.newHashSet("admin"));
        info.setStringPermissions(Sets.newHashSet("article:save", "article:delete", "user:currentUser"));
        return info;
    }
}
