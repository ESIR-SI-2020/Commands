package fr.esir.jxc.services;

import fr.esir.jxc.events.ArticleShared;
import fr.esir.jxc.models.ArticleSharedRequest;
import org.springframework.beans.factory.annotation.Autowired;

public class EventService {

    @Autowired
    Producer producer;

    public void shareArticle (ArticleSharedRequest article) {
        ArticleShared articleshared = ArticleShared.of(article);
        this.producer.produceObject(articleshared);
    }
}
