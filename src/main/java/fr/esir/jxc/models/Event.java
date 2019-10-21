package fr.esir.jxc.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import fr.esir.jxc.common.Json;
import lombok.Value;
import java.util.Optional;

@Value
public class Event {

    String eventName;
    String body;

    public Event(String simpleName, String writeValueAsString) {
    }

    public static Optional<Event> of(Object event) {
        try {
            return Optional.of(new Event(event.getClass().getSimpleName(), Json.MAPPER.writeValueAsString(event)));
        } catch (JsonProcessingException e) {
            // TODO handle the error precisely, maybe retry
            e.printStackTrace();
            return Optional.empty();
        }
    }

}