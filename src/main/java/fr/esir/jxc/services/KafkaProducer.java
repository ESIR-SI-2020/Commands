package fr.esir.jxc.services;

import com.jxc.eventstoremanager.config.KafkaTopicConfig;
import com.jxc.eventstoremanager.models.Event;
import fr.esir.jxc.controllers.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import org.springframework.util.concurrent.SettableListenableFuture;

@Service
public class KafkaProducer {

    private final KafkaTopicConfig kafkaTopicConfig;
    private final KafkaTemplate<String, Event> kafkaTemplate;

    Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    public KafkaProducer(@Autowired KafkaTemplate<String, Event> kafkaTemplate, @Autowired KafkaTopicConfig kafkaTopicConfig) {
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaTopicConfig = kafkaTopicConfig;
    }

    public ListenableFuture<SendResult<String, Event>> produce(Event event) {
        logger.debug("Sending event {0} of type {1} to topic.", event.getId(), event.getType());

        return this.kafkaTemplate.send(this.kafkaTopicConfig.TOPIC, event);
    }

    public ListenableFuture<SendResult<String, Event>> produceObject(Object event) {
        return Event.of(event)
                .map(this::produce)
                .orElseGet(() -> {
                    SettableListenableFuture<SendResult<String, Event>> error = new SettableListenableFuture<>();
                    error.setException(new RuntimeException());
                    error.cancel(true);
                    return error;
                });
    }

}
