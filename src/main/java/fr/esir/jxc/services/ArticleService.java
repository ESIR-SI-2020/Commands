package fr.esir.jxc.services;

import com.jxc.dbmanager.models.Article;

import fr.esir.jxc.events.ArticleShared;
import fr.esir.jxc.models.ArticleSharedRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired
    Producer producer;

    public void shareArticle(ArticleSharedRequest article) {
        ArticleShared articleshared = ArticleShared.of(article);
        this.producer.produceObject(articleshared);
    }


}
