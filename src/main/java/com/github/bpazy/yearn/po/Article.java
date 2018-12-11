package com.github.bpazy.yearn.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author ziyuan
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    private String articleId;
    private String title;
    private String content;
    private String status;
    private String creatorId;
    private Date createTime;
    private Date updateTime;
}
