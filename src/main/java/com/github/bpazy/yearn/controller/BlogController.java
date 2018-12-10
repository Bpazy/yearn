package com.github.bpazy.yearn.controller;

import com.github.bpazy.yearn.service.BlogService;
import com.github.bpazy.yearn.vo.BlogVo;
import com.github.bpazy.yearn.common.Result;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ziyuan
 */
@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @RequestMapping("/saveBlog")
    @RequiresPermissions("blog:save")
    public Result saveBlog(@RequestBody BlogVo blogVo) {
        blogService.saveBlog(blogVo);
        return Result.ok();
    }

    @RequestMapping("/deleteBlog/{blogId}")
    @RequiresPermissions("blog:delete")
    public Result deleteBlog(@PathVariable String blogId) {
        blogService.deleteBlog(blogId);
        return Result.ok();
    }
}
