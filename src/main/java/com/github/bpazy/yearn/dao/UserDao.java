package com.github.bpazy.yearn.dao;

import com.github.bpazy.yearn.po.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ziyuan
 */
@Mapper
public interface UserDao {
    void register(User user);
}
