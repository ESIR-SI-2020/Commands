package fr.esir.jxc.models;

import lombok.Value;

@Value
public class ArticleSharedRequest {
    String articleId;
    String ownerEmail;
    String targetEmail;

    public String getArticleId() {
        return articleId;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public String getTargetEmail() {
        return targetEmail;
    }
}
