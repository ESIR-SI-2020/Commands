package fr.esir.jxc.services;

import fr.esir.jxc.events.ArticleShared;
import fr.esir.jxc.models.ShareArticleRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShareArticleService {

    @Autowired
    Producer producer;

    public void shareArticle (String id, String ownerEmail, ShareArticleRequest article) {
        ArticleShared articleshared = ArticleShared.of(id, ownerEmail, article);
        this.producer.produceObject(articleshared);
    }
}
