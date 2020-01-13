package fr.esir.jxc.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import com.jxc.eventstoremanager.models.Event;
import fr.esir.jxc.events.ArticleCreated;
import fr.esir.jxc.events.ArticleDeleted;

import java.util.concurrent.ExecutionException;

@AllArgsConstructor
@Service
public class ArticleWriteService {

    @Autowired
    private final KafkaProducer kafkaProducer;

    public void create(String email, String url) throws ExecutionException, InterruptedException {
        ArticleCreated articleCreated = ArticleCreated.of(email, url);
        ListenableFuture<SendResult<String, Event>> event = this.kafkaProducer.produceObject(articleCreated);
        event.get(); // .get allows to wait for the computation to be completed, and throws errors
    }

    public void delete(String articleId) throws ExecutionException, InterruptedException {
        ArticleDeleted articleDeleted = ArticleDeleted.of(articleId);
        ListenableFuture<SendResult<String, Event>> event = this.kafkaProducer.produceObject(articleDeleted);
        event.get(); // .get allows to wait for the computation to be completed, and throws errors
    }
}
