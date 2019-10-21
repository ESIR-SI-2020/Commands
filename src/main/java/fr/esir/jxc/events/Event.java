package fr.esir.jxc.events;

import com.fasterxml.jackson.core.JsonProcessingException;
import fr.esir.jxc.utils.Json;
import lombok.Value;


import java.util.Optional;

@Value
public class Event {
    String eventName;
    String body;

    public Event(String eventName, String body) {
        this.eventName = eventName;
        this.body=body;
    }

    public static  Optional<Event> of(Object event)
    {
        try {
            return Optional.of(new Event(event.getClass().getSimpleName(), Json.MAPPER.writeValueAsString(event)));
        } catch (JsonProcessingException e) {
              e.printStackTrace();
            return Optional.empty();
        }

    }
}
