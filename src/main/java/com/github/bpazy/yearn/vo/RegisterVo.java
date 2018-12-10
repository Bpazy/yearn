package com.github.bpazy.yearn.vo;

import com.github.bpazy.yearn.po.User;
import lombok.Data;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @author ziyuan
 */
@Data
public class RegisterVo {
    private String username;
    private String password;

    public User toUser() {
        return User.builder()
                .username(username)
                .password(new SimpleHash("md5", password, "salt", 3).toString())
                .build();
    }
}
