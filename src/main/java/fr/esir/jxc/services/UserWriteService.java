package fr.esir.jxc.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.esir.jxc.DTO.UserCreationDTO;
import fr.esir.jxc.events.UserCreated;

@Slf4j
@AllArgsConstructor
@Service
public class UserWriteService {

    @Autowired
    private final KafkaProducer kafkaProducer;

    public void create(UserCreationDTO user) {
        log.debug("Handling creation of user {0}.", user.username);
        UserCreated userCreated = UserCreated.of(user);
        this.kafkaProducer.produceObject(userCreated);
    }

}
