package fr.esir.jxc.events;

import fr.esir.jxc.models.ArticleSharedRequest;
import lombok.Value;

@Value
public class ArticleShared {
    String articleId;
    String ownerEmail;
    String targetEmail;
    //String username;


    public ArticleShared(String articleId, String ownerEmail, String targetEmail) {
        this.articleId = articleId;
        this.ownerEmail = ownerEmail;
        this.targetEmail = targetEmail;
    }

    public static ArticleShared of(ArticleSharedRequest sharedarticle){
        return new ArticleShared(
                sharedarticle.getArticleId(),
                sharedarticle.getOwnerEmail(),
                sharedarticle.getTargetEmail());
    }
}
