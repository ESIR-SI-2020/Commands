package fr.esir.jxc.services.impl;

import fr.esir.jxc.events.UserDeleted;
import fr.esir.jxc.models.Address;
import fr.esir.jxc.events.PasswordModified;
import fr.esir.jxc.events.UserModified;
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
        PasswordModified userCreated = PasswordModified.of(email, newPassword);
        this.kafkaProducer.produceObject(userCreated);
    }

    @Override
    public void sendModifiedUserEvent(String email, String username, Address address) {
        UserModified userModified = UserModified.of(email, username, address);
        this.kafkaProducer.produceObject(userModified);
    }

    @Override
    public void sendDeletedUserEvent(String email) {
        UserDeleted userDeleted = UserDeleted.of(email);
        this.kafkaProducer.produceObject(userDeleted);
    }
}