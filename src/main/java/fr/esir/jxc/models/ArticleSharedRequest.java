package fr.esir.jxc.models;

import lombok.Value;

@Value
public class ArticleSharedRequest {
    String articleId;
    String ownerEmail;
    String targetEmail;
}
