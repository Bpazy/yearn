package com.github.bpazy.yearn.service;

import com.github.bpazy.yearn.common.BusinessException;
import com.github.bpazy.yearn.dao.UserDao;
import com.github.bpazy.yearn.security.UsernamePasswordToken;
import com.github.bpazy.yearn.vo.LoginVo;
import com.github.bpazy.yearn.vo.RegisterVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ziyuan
 */
@Slf4j
@Service
public class LoginService {
    @Autowired
    private UserDao userDao;

    public void login(LoginVo loginVo) {
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(loginVo.getUsername(), loginVo.getPassword()));
        } catch (AuthenticationException e) {
            throw new BusinessException(e.getMessage());
        }
    }

    public void register(RegisterVo registerVo) {
        userDao.register(registerVo.toUser());
    }
}
