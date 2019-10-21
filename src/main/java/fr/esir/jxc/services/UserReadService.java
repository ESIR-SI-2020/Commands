package fr.esir.jxc.services;

import com.jxc.dbmanager.models.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserReadService {
    public Optional<User> findByUsername(String username) {
        // TODO
        return Optional.empty();
    }

    public Optional<User> findByEmail(String email) {
        // TODO
        return Optional.empty();
    }
}
