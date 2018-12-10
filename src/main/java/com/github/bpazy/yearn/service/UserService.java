package com.github.bpazy.yearn.service;

import com.github.bpazy.yearn.dao.UserDao;
import com.github.bpazy.yearn.po.User;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author ziyuan
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public Set<String> queryUserRoles(String username) {
        return Sets.newHashSet();
    }

    public User findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }
}
