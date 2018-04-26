package com.ningkangkj.wxWebService.entity.resp;

import java.util.List;

/**
 * @Description 多图文消息体
 * @Author luckypt
 * @Date 2018/04/26
 */
public class NewsMessageResp extends BaseMessageResp {
    //图文消息个数,限制为8条以内
    private int ArticleCount;
    //多条图文消息信息,默认第一个item为大图,如果图文数超过8,则将会无响应
    private List<Article> Articles;

    public int getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(int articleCount) {
        ArticleCount = articleCount;
    }

    public List<Article> getArticles() {
        return Articles;
    }

    public void setArticles(List<Article> articles) {
        this.Articles = articles;
    }
}
