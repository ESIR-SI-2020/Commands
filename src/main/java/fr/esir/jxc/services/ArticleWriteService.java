package fr.esir.jxc.services;

import fr.esir.jxc.events.ArticleCreated;
import fr.esir.jxc.events.ArticleDeleted;
import com.jxc.eventstoremanager.models.Event;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;

@AllArgsConstructor
@Service
public class ArticleWriteService {

    @Autowired
    private final KafkaProducer kafkaProducer;

    public void create(String email, String url) {
        ArticleCreated articleCreated = ArticleCreated.of(email, url);
        ListenableFuture<SendResult<String, Event>> event = this.kafkaProducer.produceObject(articleCreated);
    }

    public void delete(String articleId) {
        ArticleDeleted articleDeleted = ArticleDeleted.of(articleId);
        ListenableFuture<SendResult<String, Event>> event = this.kafkaProducer.produceObject(articleDeleted);
    }
}
