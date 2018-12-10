package com.github.bpazy.yearn.service;

import com.google.common.collect.Sets;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author ziyuan
 */
@Service
public class UserService {
    public Set<String> queryUserRoles(String username) {
        return Sets.newHashSet();
    }
}
