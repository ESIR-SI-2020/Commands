package fr.esir.jxc.services;

import fr.esir.jxc.DTO.ArticleCreationDTO;
import fr.esir.jxc.events.ArticleCreated;
import fr.esir.jxc.events.ArticleDeleted;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    private final KafkaProducer kafkaProducer;

    public ArticleService(@Autowired KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    public void sendCreateArticleEvent(String email, String url){
        ArticleCreated articleCreated = ArticleCreated.of(email, url);
        this.kafkaProducer.produceObject(articleCreated);
    }

    public void sendDeletedArticleEvent(String articleId) {
        ArticleDeleted articleDeleted = ArticleDeleted.of(articleId);
        this.kafkaProducer.produceObject(articleDeleted);
    }
}
