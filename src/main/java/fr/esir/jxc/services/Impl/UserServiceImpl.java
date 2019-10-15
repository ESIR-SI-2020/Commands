package fr.esir.jxc.services.Impl;

import fr.esir.jxc.services.KafkaProducer;
import fr.esir.jxc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    

    @Autowired
    private KafkaProducer sender;

    public void sendModifiedPasswordEvent(String email, String newPassword){
        ModifiedPasswordResponse response = new ModifiedPasswordResponse(email, newPassword);
        sender.send(response);
        receiver.getLatch();//.await(10000, TimeUnit.MILLISECONDS);
        System.out.println("Si reçu, le consommateur renverra le nombre 0 : " + receiver.getLatch().getCount());
    }
}