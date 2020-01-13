package fr.esir.jxc.services;

import com.jxc.eventstoremanager.models.Event;
import fr.esir.jxc.DTO.ArticleCreationDTO;
import fr.esir.jxc.events.ArticleCreated;
import fr.esir.jxc.events.ArticleDeleted;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;

@Service
public class ArticleService {

    private final KafkaProducer kafkaProducer;

    public ArticleService(@Autowired KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    public void sendCreateArticleEvent(String email, String url) throws ExecutionException, InterruptedException {
        ArticleCreated articleCreated = ArticleCreated.of(email, url);
        ListenableFuture<SendResult<String, Event>> event = this.kafkaProducer.produceObject(articleCreated);
        event.get(); // .get allows to wait for the computation to be completed, and throws errors
    }

    public void sendDeletedArticleEvent(String articleId) throws ExecutionException, InterruptedException {
        ArticleDeleted articleDeleted = ArticleDeleted.of(articleId);
        ListenableFuture<SendResult<String, Event>> event = this.kafkaProducer.produceObject(articleDeleted);
        event.get(); // .get allows to wait for the computation to be completed, and throws errors
    }
}
