package fr.esir.jxc.services.Impl;

import fr.esir.jxc.models.ResponseCreated;
import fr.esir.jxc.services.KafkaServices.KafkaProducer;
import fr.esir.jxc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final KafkaProducer kafkaProducer;

    public UserServiceImpl(@Autowired KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    public void sendModifiedPasswordEvent(String email, String newPassword){
        ResponseCreated userCreated = ResponseCreated.of(email, newPassword);
        this.kafkaProducer.produceObject(userCreated);
    }
}