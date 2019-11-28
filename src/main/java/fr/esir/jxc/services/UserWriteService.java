package fr.esir.jxc.services;

import fr.esir.jxc.DTO.UserCreationDTO;
import fr.esir.jxc.events.UserCreated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserWriteService {

    private final KafkaProducer kafkaProducer;

    Logger logger = LoggerFactory.getLogger(UserWriteService.class);

    public UserWriteService(@Autowired  KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    public void create(UserCreationDTO user) {
        logger.debug("Handling creation of user {0}.", user.username);
        UserCreated userCreated = UserCreated.of(user);

        this.kafkaProducer.produceObject(userCreated);
    }

}
