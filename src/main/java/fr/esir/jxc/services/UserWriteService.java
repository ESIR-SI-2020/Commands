package fr.esir.jxc.services;

import fr.esir.jxc.DTO.UserCreationDTO;
import fr.esir.jxc.events.UserCreated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserWriteService {

    private final KafkaProducer kafkaProducer;

    public UserWriteService(@Autowired  KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    public void create(UserCreationDTO user) {
        UserCreated userCreated = UserCreated.of(user);
        this.kafkaProducer.produceObject(userCreated);
    }

}
