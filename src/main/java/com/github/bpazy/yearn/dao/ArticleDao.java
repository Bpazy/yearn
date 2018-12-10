package com.github.bpazy.yearn.dao;

import com.github.bpazy.yearn.po.Article;
import org.apache.ibatis.annotations.*;

/**
 * @author ziyuan
 */
@Mapper
public interface ArticleDao {
    @Update("update article set title = #{title}, content = #{content}, status = #{status} where article_id = #{articleId}")
    void updateArticle(Article article);

    @Select("select article_id, title, content, status, create_time, update_time from article where article_id = #{articleId}")
    Article findArticle(@Param("articleId") String articleId);

    @Insert("insert into article (article_id, title, content, status) values (#{articleId}, #{title}, #{content}, #{status})")
    void saveArticle(Article article);
}
