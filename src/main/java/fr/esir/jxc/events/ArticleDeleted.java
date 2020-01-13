package fr.esir.jxc.events;

import lombok.Value;

@Value
public class ArticleDeleted {

    String articleId;

    public ArticleDeleted(String articleId) {
        this.articleId = articleId;
    }


    public static ArticleDeleted of(String articleId) {
        return new ArticleDeleted(
                articleId
        );
    }

}