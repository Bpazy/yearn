package com.github.bpazy.yearn.controller;

import com.github.bpazy.yearn.common.ResultGenerator;
import com.github.bpazy.yearn.service.ArticleService;
import com.github.bpazy.yearn.vo.ArticleVo;
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
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/saveArticle")
    @RequiresPermissions("article:save")
    public Result saveBlog(@RequestBody ArticleVo articleVo) {
        articleService.saveArticle(articleVo);
        return ResultGenerator.ok();
    }

    @RequestMapping("/deleteArticle/{articleId}")
    @RequiresPermissions("article:delete")
    public Result deleteBlog(@PathVariable String articleId) {
        articleService.deleteArticle(articleId);
        return ResultGenerator.ok();
    }
}
