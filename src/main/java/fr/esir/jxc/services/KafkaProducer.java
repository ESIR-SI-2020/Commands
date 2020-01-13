package fr.esir.jxc.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.SettableListenableFuture;

import lombok.extern.slf4j.Slf4j;

import com.jxc.eventstoremanager.config.KafkaTopicConfig;
import com.jxc.eventstoremanager.models.Event;

@Slf4j
@Service
@AllArgsConstructor
public class KafkaProducer {
    @Autowired
    private final KafkaTopicConfig kafkaTopicConfig;
    @Autowired
    private final KafkaTemplate<String, Event> kafkaTemplate;

    public ListenableFuture<SendResult<String, Event>> produce(Event event) {
        log.debug("Sending event {0} of type {1} to topic.", event.getId(), event.getType());

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
