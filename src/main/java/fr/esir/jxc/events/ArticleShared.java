package fr.esir.jxc.events;

import fr.esir.jxc.models.ShareArticleRequest;
import lombok.Value;

import java.util.List;

@Value
public class ArticleShared {
    String articleId;
    String ownerEmail;
    List<String> targetEmails;

    public static ArticleShared of(String id, String ownerEmail, ShareArticleRequest sharedArticle){
        return new ArticleShared(
                id,
                ownerEmail,
                sharedArticle.getTargetEmails());
    }
}
