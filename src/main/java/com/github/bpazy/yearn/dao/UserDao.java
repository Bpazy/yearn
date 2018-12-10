package com.github.bpazy.yearn.dao;

import com.github.bpazy.yearn.po.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author ziyuan
 */
@Mapper
public interface UserDao {
    @Insert("insert into user (user_id, username, password) values (#{userId}, #{username}, #{password})")
    void register(User user);

    @Select("select user_id, username, password, create_time, update_time from user where username = #{username}")
    User findUserByUsername(@Param("username") String username);
}
