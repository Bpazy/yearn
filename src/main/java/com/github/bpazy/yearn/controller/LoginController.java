package com.github.bpazy.yearn.controller;

import com.github.bpazy.yearn.common.Result;
import com.github.bpazy.yearn.service.LoginService;
import com.github.bpazy.yearn.vo.LoginVo;
import com.github.bpazy.yearn.vo.RegisterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ziyuan
 */
@RestController
@RequestMapping
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public Result login(@RequestBody LoginVo loginVo) {
        loginService.login(loginVo);
        return Result.ok();
    }

    @RequestMapping("/register")
    public Result register(@RequestBody RegisterVo registerVo) {
        loginService.register(registerVo);
        return Result.ok();
    }
}
