package fr.esir.jxc.services.impl;

import fr.esir.jxc.events.ArticleCreated;
import fr.esir.jxc.events.ArticleDeleted;
import fr.esir.jxc.services.ArticleService;
import fr.esir.jxc.services.KafkaServices.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final KafkaProducer kafkaProducer;

    public ArticleServiceImpl(@Autowired KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @Override
    public void sendCreateArticleEvent(String email, String url){
        ArticleCreated articleCreated = ArticleCreated.of(email, url);
        this.kafkaProducer.produceObject(articleCreated);
    }

    @Override
    public void sendDeletedArticleEvent(String articleId) {
        ArticleDeleted articleDeleted = ArticleDeleted.of(articleId);
        this.kafkaProducer.produceObject(articleDeleted);
    }
}