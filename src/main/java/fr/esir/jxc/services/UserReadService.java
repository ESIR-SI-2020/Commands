package fr.esir.jxc.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.esir.jxc.domain.models.User;

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
