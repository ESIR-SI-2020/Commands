package fr.esir.jxc.services.impl;

import fr.esir.jxc.DTO.ArticleCreationDTO;
import fr.esir.jxc.models.ArticleCreated;
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

    public void sendCreateArticleEvent(ArticleCreationDTO articleCreationDTO){
        ArticleCreated articleCreated = ArticleCreated.of(articleCreationDTO);
        this.kafkaProducer.produceObject(articleCreated);
    }
}