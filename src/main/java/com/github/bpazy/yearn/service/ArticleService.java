package com.github.bpazy.yearn.service;

import com.github.bpazy.id.Id;
import com.github.bpazy.yearn.constant.ArticleStatusEnum;
import com.github.bpazy.yearn.dao.ArticleDao;
import com.github.bpazy.yearn.po.Article;
import com.github.bpazy.yearn.vo.ArticleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ziyuan
 */
@Service
public class ArticleService {
    @Autowired
    private ArticleDao articleDao;

    public void saveArticle(ArticleVo articleVo) {
        articleDao.saveBlog(Article.builder()
                .articleId(Id.next() + "")
                .title(articleVo.getTitle())
                .content(articleVo.getContent())
                .status(ArticleStatusEnum.正常.name())
                .build());
    }

    public void deleteArticle(String articleId) {
        Article article = articleDao.findArticle(articleId);
        article.setStatus(ArticleStatusEnum.已删除.name());
        articleDao.updateArticle(article);
    }
}
