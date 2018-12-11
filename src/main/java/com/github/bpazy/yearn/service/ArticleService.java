package com.github.bpazy.yearn.service;

import com.github.bpazy.id.Id;
import com.github.bpazy.yearn.common.BusinessException;
import com.github.bpazy.yearn.common.Constants;
import com.github.bpazy.yearn.constant.ArticleStatusEnum;
import com.github.bpazy.yearn.dao.ArticleDao;
import com.github.bpazy.yearn.po.Article;
import com.github.bpazy.yearn.security.UserStatic;
import com.github.bpazy.yearn.vo.ArticleVo;
import org.apache.commons.lang3.StringUtils;
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
        Article.ArticleBuilder articleBuilder = Article.builder()
                .title(articleVo.getTitle())
                .content(articleVo.getContent())
                .status(ArticleStatusEnum.正常.name());
        if (StringUtils.isBlank(articleVo.getArticleId())) {
            articleDao.saveArticle(articleBuilder.articleId(Id.next() + "").build());
        } else {
            Article article = articleDao.findArticle(articleVo.getArticleId());
            if (!StringUtils.equals(article.getCreatorId(), UserStatic.getUser().getUserId())) {
                throw new BusinessException(Constants.ACCESS_DENIED);
            }
            articleDao.updateArticle(articleBuilder.articleId(articleVo.getArticleId()).build());
        }
    }

    public void deleteArticle(String articleId) {
        Article article = articleDao.findArticle(articleId);
        if (article == null) throw new BusinessException(Constants.ARTICLE_NOT_EXISTS);

        article.setStatus(ArticleStatusEnum.已删除.name());
        articleDao.updateArticle(article);
    }
}
